class Solution {
    HashMap<String, String> parent = new HashMap<>(); 
    HashMap<Integer, TreeSet<String>> emailset = new HashMap<>();
    HashMap<String, Integer> index = new HashMap<>();

    private String findRoot(String mail){
        if(parent.containsKey(mail)){
            if(parent.get(mail).equals(mail)) return mail;
            else return findRoot(parent.get(mail));
        }
        return null;
    }
    public List<List<String>> accountsMerge(List<List<String>> accounts) {


        for(int i = 0; i<accounts.size(); i++){
            List<String> account = accounts.get(i);
            String first_mail = account.get(1);
            
            if(findRoot(first_mail)==null){
                parent.put(first_mail, first_mail);
                index.put(first_mail, i);
            }else{
                first_mail = findRoot(first_mail);
            }
            for(int j = 2; j<account.size(); j++){
                String mail = account.get(j);
                if(findRoot(mail)==null){
                    parent.put(mail, first_mail);
                }else{
                    parent.put(findRoot(mail), first_mail);
                }
            }
        }
        
        for(String mail:parent.keySet()){
            String root = findRoot(mail);
            int root_index = index.get(root);
            if(emailset.containsKey(root_index)){
                TreeSet<String> set = emailset.get(root_index);
                set.add(mail);
            }else{
                TreeSet<String> set = new TreeSet<>();
                set.add(mail);
                emailset.put(root_index, set);
            }
        }
        
        List<List<String>> res = new ArrayList<>();
        
        for(Integer index:emailset.keySet()){
            List<String> group = new ArrayList<String>(emailset.get(index));
            group.add(0, accounts.get(index).get(0));
            res.add(group);
        }
        return res;
    }
}
