import sys
import subprocess 

#TODO - include if i want to push 
def main():
    arg_list = sys.argv[1:]
    if (".txt" not in arg_list[0] and len(arg_list) < 6):
        print("You have not enter enough arguments (category,id,title,diffcuitly,language,file name, n - don`t push)")

    else:
        output, titles = readFile()
        multi_q = False
        commit_str = "\"Completed "
        info = formatArgs(arg_list)
        if (".txt" in arg_list[0]):
            #TODO
            multi_q = True
            pass
        else:
            insertLine(output,info,titles)
            arg_list = [arg_list]

        write_to_file(output,titles)
        for entry in arg_list:
            if not multi_q:
                commit_str += entry[2] + "- ID " + entry[1]
            else:
                #TODO
                pass
     
        command = ["git status","git add -A", "git status", "git commit -m " + commit_str + "\"", "git push"]        
        check = ["not staged for commit","" ,"Changes to be committed:", "files changed", "To https://github.com"]
        prompts = ["Checking if there is any thing to commit", "Added files to commmit", "Ready to commit","Committing", "Pushed to git"]
        print("Executing commands to push to git")
        x = 0
        while x < len(command):
            if command[x] == "git push" and not info["push"]:  
                print("Did not push")
                break;
            else:
                error_code = subprocess.check_output(command[x],shell = True, text = True)
                if check[x] not in error_code and x == 0:
                    x += 1
                elif check[x] not in error_code:
                    break;
                else:
                    print(prompts[x])
                x += 1

def formatArgs(args_list):
    info = {}
    info["category"] = args_list[0]
    info["id"] = args_list[1]
    info["title"] = args_list[2]
    info["diffcuitly"] = args_list[3]
    info["language"] = args_list[4]
    info["fileName"] = args_list[5]
    info["push"] = len(args_list) == 7 and (args_list[6] == "y" or args_list[6] == "yes")
    return info

def readFile():
    output = {}
    titles = ["header"]
    title = "header"
    output[title] = []
    readme = open("README.md", 'r', encoding="utf-8")

    for line in readme:
        line = line.strip()
        if "#"*3 in line:
            title = line
            titles.append(title)
            output[title] = []
        if line != "":
            output[title].append(line)

    return output,titles
def break_prev_link(prev_glink):
    glink_parts_dict = {}
    prev_glink_parts = prev_glink.split("/")
    glink_parts_dict["common"] = prev_glink_parts[0] + "//" + prev_glink_parts[2] + "/"
    glink_parts_dict["common"] += "/".join(prev_glink_parts[3:7])
    glink_parts_dict["website"] = prev_glink_parts[7]
    glink_parts_dict["diffcuitly"] = prev_glink_parts[8]
    glink_parts_dict["category"] = prev_glink_parts[9]
    return glink_parts_dict

def get_g_link(output,entry,last_title):
    search = last_title.replace("### ", "")
    entry["title"] = entry["title"].replace("_"," ")

    g_link = output[last_title][-1].find("https://github.com")
    g_link_end = output[last_title][-1].find(search+"/")
    previous_glink = output[last_title][-1][g_link:g_link_end + len(search)]

    g_link = break_prev_link(previous_glink)
    g_link["diffcuitly"] = entry["diffcuitly"]
    g_link["category"] = entry["category"]
    g_link = g_link["common"] + "/" + g_link["website"] + "/" + g_link["diffcuitly"] + "/" + g_link["category"] + "/" + entry["fileName"]
    return g_link

def insertHeader(output,title):
    output[title].append(title)
    output[title].append("| #  |  Title | Diffcuitly  |  Language  |")
    output[title].append("| ------------ | ------------ | ------------ | ------------ |")

def insertLine(output, info , titles):
    title = "### " + info["category"]
    if title in output.keys():
        g_link = get_g_link(output,info,title)
    else:
        output[title] = []
        g_link = get_g_link(output, info ,titles[-1])
        g_link = g_link.replace(titles[-1].replace("### ",""),info["category"]) 
        titles.append(title)
        insertHeader(output,title)

    info["title"] = info["title"].split(" ")
    domain = "-cn" if "~" in info["title"][-1] else ""
    symbols = ["~", "+"]
    p_link = info["title"]
    for symbol in symbols:
        p_link = [x[:-1] if x[-1] in symbol else x for x in p_link]
    
    p_link = "-".join(p_link)
    p_link = "https://leetcode"+ domain +".com/problems/" + p_link + "/"
    info["title"] = " ".join([x.capitalize() for x in info["title"] ])

    f_col = "| {:4} |".format(info["id"])
    s_col = " [{}]({} \"{}\") ".format(info["title"],p_link,info["title"])
    t_col = "| {} |".format(info["diffcuitly"])
    fourth_col = " [{}]({})|".format(info["language"],g_link)
    output[title].append(f_col+s_col+t_col+fourth_col)

def write_to_file(output,titles):
    readme = open("README.md", 'w', encoding="utf-8")
    for title in titles:
        for value in output[title]:
            print(value , file = readme)
        print("",file=readme)
main()
