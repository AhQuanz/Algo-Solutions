import sys
import subprocess 

#TODO - include if i want to push 
def main():
    arg_list = sys.argv[1:]
    if (".txt" not in arg_list[0] and len(arg_list) < 7):
        print("You have not enter enough arguments (category,id,title,diffcuitly,language,file name, n - don`t push)")

    else:
        output, titles = readFile()
        multi_q = False
        commit_str = "\"Completed "
        if (".txt" in arg_list[0]):
            #TODO
            multi_q = True
            pass
        else:
            insertLine(output,arg_list,titles)
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
            if command[x] == "git push" and entry[6][0].lower() == 'n':  
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

def readFile():
    output = {}
    titles = ["header"]
    title = "header"
    output[title] = []
    readme = open("README.md", 'r')

    for line in readme:
        line = line.strip()
        if "#"*3 in line:
            title = line
            titles.append(title)
            output[title] = []
        if line != "":
            output[title].append(line)

    return output,titles

def get_g_link(output,entry,title):
    search = title.replace("### ", "")
    entry[2] = entry[2].replace("_"," ")
    g_link = output[title][-1].find("https://github.com")
    #TODO update g_link_end to end at leetcode instead of diffcuilty so that we can change
    g_link_end = output[title][-1].find(search+"/")
    g_link = output[title][-1][g_link:g_link_end+len(search)] + "/" + entry[5]
    return g_link

def insertHeader(output,title):
    output[title].append(title)
    output[title].append("| #  |  Title | Diffcuitly  |  Language  |")
    output[title].append("| ------------ | ------------ | ------------ | ------------ |")

def insertLine(output, entry,titles):
    title = "### " + entry[0]
    if title in output.keys():
        g_link = get_g_link(output,entry,title)
    else:
        output[title] = []
        g_link = get_g_link(output,entry,titles[-1])
        g_link = g_link.replace(titles[-1].replace("### ",""),entry[0]) 
        titles.append(title)
        insertHeader(output,title)
    
    entry[2] = entry[2].split(" ")
    domain = "-cn" if "~" in entry[2][-1] else ""
    symbols = ["~", "+"]
    p_link = entry[2]
    for symbol in symbols:
        p_link = [x[:-1] if x[-1] in symbol else x for x in p_link]
    
    p_link = "-".join(p_link)
    p_link = "https://leetcode"+ domain +".com/problems/" + p_link + "/"
    entry[2] = " ".join([x.capitalize() for x in entry[2] ])

    f_col = "| {:4} |".format(entry[1])
    s_col = " [{}]({} \"{}\") ".format(entry[2],p_link,entry[2])
    t_col = "| {} |".format(entry[3])
    fourth_col = " [{}]({})|".format(entry[4],g_link)
    output[title].append(f_col+s_col+t_col+fourth_col)


def write_to_file(output,titles):
    readme = open("README.md", 'w')
    for title in titles:
        for value in output[title]:
            print(value , file = readme)
        print("",file=readme)
main()
