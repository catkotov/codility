package org.cat.eye.leetcode;

import java.util.*;

public class VerticalOrderTraversal {

    Map<Integer, ArrayList<Pair<Integer, Integer>>> columnTable = new HashMap<>();
    int minColumn = 0, maxColumn = 0;

    private void DFS(TreeNode node, Integer row, Integer column) {
        if (node == null)
            return;

        if (!columnTable.containsKey(column)) {
            this.columnTable.put(column, new ArrayList<>());
        }

        this.columnTable.get(column).add(new Pair<>(row, node.val));
        this.minColumn = Math.min(minColumn, column);
        this.maxColumn = Math.max(maxColumn, column);
        // preorder DFS traversal
        this.DFS(node.left, row + 1, column - 1);
        this.DFS(node.right, row + 1, column + 1);
    }

    public List<List<Integer>> verticalOder_2(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return  result;
        }

        Map<Integer, List<Integer>> columnValue = new HashMap<>();

        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        int column = 0;

        int minColumn = 0, maxColumn = 0;

        queue.offer(new Pair<>(root, column));

        while (!queue.isEmpty()) {

            Pair<TreeNode, Integer> pair = queue.poll();

            root = pair.getKey();
            column = pair.getValue();

            if (root != null) {

                if (!columnValue.containsKey(column)) {
                    columnValue.put(column, new ArrayList<>());
                }
                columnValue.get(column).add(root.val);

                minColumn = Math.min(minColumn, column);
                maxColumn = Math.max(maxColumn, column);

                queue.offer(new Pair<>(root.left, column - 1));
                queue.offer(new Pair<>(root.right, column + 1));
            }
        }

        for (int i = minColumn; i <= maxColumn; i++) {
            result.add(columnValue.get(i));
        }

        return result;
    }

    public List<List<Integer>> verticalOder_1(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return  result;
        }

        Map<Integer, List<Integer>> columnValue = new HashMap<>();

        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        int column = 0;

        queue.offer(new Pair<>(root, column));

        while (!queue.isEmpty()) {

            Pair<TreeNode, Integer> pair = queue.poll();

            root = pair.getKey();
            column = pair.getValue();

            if (root != null) {

                if (!columnValue.containsKey(column)) {
                    columnValue.put(column, new ArrayList<>());
                }
                columnValue.get(column).add(root.val);

                queue.offer(new Pair<>(root.left, column - 1));
                queue.offer(new Pair<>(root.right, column + 1));
            }
        }

        columnValue.keySet().stream().sorted().forEach(key -> {
            result.add(columnValue.get(key));
        });

        return result;
    }

    public List<List<Integer>> verticalOrder(TreeNode root) {

        LinkedHashMap<TreeNode, List<Integer>> valueToColumn = new LinkedHashMap<>();
        Map<Integer, List<Integer>> columns = new LinkedHashMap<>();

        verticalPostOrder(root, valueToColumn, 0);

        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);

        do {
            TreeNode entry = queue.poll();
            if (entry != null) {

                Integer column = valueToColumn.get(entry).remove(0);

                if (columns.get(column) == null) {
                    List<Integer> tmp = new LinkedList<>();
                    tmp.add(entry.val);
                    columns.put(column, tmp);
                } else {
                    columns.get(column).add(entry.val);
                }

                if (entry.left != null) {
                    queue.offer(entry.left);
                }

                if (entry.right != null) {
                    queue.offer(entry.right);
                }
            }

        } while (!queue.isEmpty());


        List<List<Integer>> result = new LinkedList<>();

        columns.keySet().stream().sorted().forEach(key -> result.add(columns.get(key)));

        return result;
    }

    public static void verticalPostOrder(TreeNode root, Map<TreeNode, List<Integer>> valueToColumn, int columnIdx) {

        if (root != null) {
            if (valueToColumn.get(root) == null) {
                List<Integer> tmp = new LinkedList<>();
                tmp.add(columnIdx);
                valueToColumn.put(root, tmp);
            } else {
                valueToColumn.get(root).add(columnIdx);
            }

            if (root.left != null) {
                verticalPostOrder(root.left, valueToColumn, columnIdx - 1);
            }
            if (root.right != null) {
                verticalPostOrder(root.right, valueToColumn, columnIdx + 1);
            }
        }
    }

}

