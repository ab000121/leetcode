class Solution {

    class Node {
        char leftChar, rightChar;
        int left, right, best, len;

        Node(char c) {
            leftChar = c;
            rightChar = c;
            left = right = best = len = 1;
        }

        Node() {
        }
    }

    Node[] tree;

    public int[] longestRepeating(String s, String queryCharacters, int[] queryIndices) {

        int n = s.length();
        tree = new Node[4 * n];

        build(s, 1, 0, n - 1);

        int[] result = new int[queryIndices.length];

        for (int i = 0; i < queryIndices.length; i++) {

            int idx = queryIndices[i];
            char ch = queryCharacters.charAt(i);

            update(1, 0, n - 1, idx, ch);

            result[i] = tree[1].best;
        }

        return result;
    }

    private void build(String s, int node, int l, int r) {

        if (l == r) {
            tree[node] = new Node(s.charAt(l));
            return;
        }

        int mid = l + (r - l) / 2;

        build(s, node * 2, l, mid);
        build(s, node * 2 + 1, mid + 1, r);

        tree[node] = merge(tree[node * 2], tree[node * 2 + 1]);
    }

    private void update(int node, int l, int r, int idx, char ch) {

        if (l == r) {
            tree[node] = new Node(ch);
            return;
        }

        int mid = l + (r - l) / 2;

        if (idx <= mid) {
            update(node * 2, l, mid, idx, ch);
        } else {
            update(node * 2 + 1, mid + 1, r, idx, ch);
        }

        tree[node] = merge(tree[node * 2], tree[node * 2 + 1]);
    }

    private Node merge(Node a, Node b) {

        Node res = new Node();

        res.len = a.len + b.len;

        res.leftChar = a.leftChar;
        res.rightChar = b.rightChar;

        res.left = a.left;
        res.right = b.right;

        res.best = Math.max(a.best, b.best);

        if (a.rightChar == b.leftChar) {

            res.best = Math.max(
                res.best,
                a.right + b.left
            );

            if (a.left == a.len) {
                res.left = a.len + b.left;
            }

            if (b.right == b.len) {
                res.right = b.len + a.right;
            }
        }

        return res;
    }
}