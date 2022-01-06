class Solution {
    public String simplifyPath(String path) {
        String[] arr = path.split("/");
        Deque<String> dq = new ArrayDeque();
        for (String str : arr) {
            if (str.equals("") || str.equals(".")) {
                continue;
            } else if (str.equals("..")) {
                if (!dq.isEmpty()) {
                    dq.removeLast();
                }
            } else {
                dq.addLast(str);
            }
        }
        if (dq.isEmpty()) {
            return "/";
        }
        StringBuilder sb = new StringBuilder();
        while (!dq.isEmpty()) {
            sb.append("/").append(dq.removeFirst());
        }
        return sb.toString();
    }
}
