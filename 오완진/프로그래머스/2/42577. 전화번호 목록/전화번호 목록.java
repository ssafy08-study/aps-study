class Trie {
    Trie[] child = new Trie[10];
    boolean isEnd = false;
}

class Solution {
    public boolean solution(String[] phone_book) {
        Trie root = new Trie();
        boolean isConsistent = true;

        for (String phoneNumber : phone_book) {
            if (!insert(root, phoneNumber)) {
                isConsistent = false;
                break;
            }
        }

        return isConsistent;
    }

    static boolean insert(Trie root, String phoneNumber) {
        Trie currNode = root;

        for (char ch : phoneNumber.toCharArray()) {
            int num = ch - '0';
            if (currNode.child[num] == null)
                currNode.child[num] = new Trie();

            currNode = currNode.child[num];

            // 123 1234
            if (currNode.isEnd) return false;
        }

        // 123 123
        if (currNode.isEnd) return false;

        currNode.isEnd = true;

        // 1234 123
        for (Trie child : currNode.child)
            if (child != null) return false;

        return true;
    }
}
