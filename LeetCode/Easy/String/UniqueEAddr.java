/*
https://leetcode.com/problems/unique-email-addresses/
Every email consists of a local name and a domain name, separated by the @ sign.
For example, in alice@leetcode.com, alice is the local name, and leetcode.com is the domain name.
Besides lowercase letters, these emails may contain '.'s or '+'s.
If you add periods ('.') between some characters in the local name part of an email address, mail sent there will be forwarded to the same address without dots in the local name.  
For example, "alice.z@leetcode.com" and "alicez@leetcode.com" forward to the same email address.  
(Note that this rule does not apply for domain names.
If you add a plus ('+') in the local name, everything after the first plus sign will be ignored. 
This allows certain emails to be filtered, for example m.y+name@email.com will be forwarded to my@email.com.  (Again, this rule does not apply for domain names.)
It is possible to use both of these rules at the same time.
Given a list of emails, we send one email to each address in the list.  How many different addresses actually receive mails

Input: ["test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"]
Output: 2

Input: ["test.email+alex@leetcode.com", "test.email@leetcode.com"]
Output : 2
*/
class UniqueEAddr {
    public int numUniqueEmails(String[] emails) {
        HashSet<String> unique_e = new HashSet<>();
        for(String email : emails) {
            // [domain, +]
            BitSet special = new BitSet(2);
            StringBuilder local = new StringBuilder();
            StringBuilder domain = new StringBuilder(); 
            for(int i = 0; i < email.length(); i++) {
                char c = email.charAt(i);
                if(special.get(0)) {
                    domain.append(c);
                } else if (c == '@') {
                    domain.append(c);
                    special.set(0);
                } else if (c == '+') {
                    special.set(1);
                } else if (c != '.' && !special.get(1)) {
                    local.append(c);
                }
            }
            unique_e.add(local.append(domain).toString());
        }
        return unique_e.size();
    }
}
