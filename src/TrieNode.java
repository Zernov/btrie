import sun.text.normalizer.Trie;

import java.util.ArrayList;

public class TrieNode extends Node {

    public Node[] children;
    public String prefix;

    public TrieNode() {
        this.children = new Node[Global.SIZE];
        this.prefix = "";
    }

    public boolean isBucket() { return false; }

    public boolean add(String item, String prefix) {
        int index = (int)item.charAt(0) - Global.FROM;
        if (children[index] != null) {
            boolean split;
            if (children[index].isBucket()) {
                Bucket bucket = (Bucket)children[index];
                if (bucket.isPure()) {
                    split = children[index].add(item.substring(1), (prefix + item.charAt(0)));
                    if (split) {
                        bucket.from = 0;
                        bucket.to = Global.SIZE - 1;
                        TrieNode trieNode = new TrieNode();
                        trieNode.prefix = (prefix + item.charAt(0));
                        for (int i = 0; i < bucket.items.size(); i++) {
                            trieNode.children[i] = bucket;
                        }
                        this.children[index] = trieNode;
                        Pair borders = getNeighbouringItems(bucket.items);
                        ArrayList<String> firstItems = new ArrayList<>();
                        firstItems.add(bucket.items.get(borders.first));
                        for (int i = 0; i < borders.first; i++) {
                            firstItems.add(bucket.items.get(i));
                        }
                        int firstFrom = (int)firstItems.get(0).charAt(0) - Global.FROM;
                        int firstTo = (int)firstItems.get(firstItems.size() - 1).charAt(0) - Global.FROM;
                        Bucket firstBucket = new Bucket(firstFrom, firstTo, bucket.prefix, firstItems);
                        ArrayList<String> secondItems = new ArrayList<>();
                        secondItems.add(bucket.items.get(borders.second));
                        for (int i = borders.second; i < bucket.items.size() - 1; i++) {
                            secondItems.add(bucket.items.get(i));
                        }
                        int secondFrom = (int)secondItems.get(0).charAt(0) - Global.FROM;
                        int secondTo = (int)secondItems.get(secondItems.size() - 1).charAt(0) - Global.FROM;
                        Bucket secondBucket = new Bucket(secondFrom, secondTo, bucket.prefix, secondItems);
                        for (int i = 0; i < firstFrom; i++) {
                            trieNode.children[i] = null;
                        }
                        for (int i = firstFrom; i < firstTo + 1; i++) {
                            trieNode.children[i] = firstBucket;
                        }
                        for (int i = firstTo + 1; i < secondFrom; i++) {
                            trieNode.children[i] = null;
                        }
                        for (int i = secondFrom; i < secondTo + 1; i++) {
                            trieNode.children[i] = secondBucket;
                        }
                        for (int i = secondTo + 1; i < children.length; i++) {
                            trieNode.children[i] = null;
                        }
                        split = false;
                    }
                } else {
                    split = children[index].add(item, prefix);
                    if (split) {
                        Pair borders = getNeighbouringItems(bucket.items);
                        if (borders.first == -1) {
                            bucket.prefix += bucket.items.get(0).charAt(0);
                            for (int i = bucket.from; i < bucket.to + 1; i++) {
                                this.children[i] = null;
                            }
                            for (int i = 0; i < bucket.items.size(); i++) {
                                bucket.items.set(i, bucket.items.get(i).substring(1));
                            }
                            borders = getNeighbouringItems(bucket.items);
                            bucket.from = 0;
                            bucket.to = Global.SIZE - 1;
                            TrieNode trieNode = new TrieNode();
                            trieNode.prefix = prefix;
                            for (int i = 0; i < trieNode.children.length; i++) {
                                trieNode.children[i] = bucket;
                            }
                            this.children[index] = trieNode;
                            ArrayList<String> firstItems = new ArrayList<>();
                            firstItems.add(bucket.items.get(borders.first));
                            for (int i = 0; i < borders.first; i++) {
                                firstItems.add(bucket.items.get(i));
                            }
                            int firstFrom = (int)firstItems.get(0).charAt(0) - Global.FROM;
                            int firstTo = (int)firstItems.get(firstItems.size() - 1).charAt(0) - Global.FROM;
                            Bucket firstBucket = new Bucket(firstFrom, firstTo, bucket.prefix, firstItems);
                            ArrayList<String> secondItems = new ArrayList<>();
                            secondItems.add(bucket.items.get(borders.second));
                            for (int i = borders.second; i < bucket.items.size() - 1; i++) {
                                secondItems.add(bucket.items.get(i));
                            }
                            int secondFrom = (int)secondItems.get(0).charAt(0) - Global.FROM;
                            int secondTo = (int)secondItems.get(secondItems.size() - 1).charAt(0) - Global.FROM;
                            Bucket secondBucket = new Bucket(secondFrom, secondTo, bucket.prefix, secondItems);
                            for (int i = 0; i < firstFrom; i++) {
                                trieNode.children[i] = null;
                            }
                            for (int i = firstFrom; i < firstTo + 1; i++) {
                                trieNode.children[i] = firstBucket;
                            }
                            for (int i = firstTo + 1; i < secondFrom; i++) {
                                trieNode.children[i] = null;
                            }
                            for (int i = secondFrom; i < secondTo + 1; i++) {
                                trieNode.children[i] = secondBucket;
                            }
                            for (int i = secondTo + 1; i < children.length; i++) {
                                trieNode.children[i] = null;
                            }
                        } else {
                            ArrayList<String> firstItems = new ArrayList<>();
                            firstItems.add(bucket.items.get(borders.first));
                            for (int i = 0; i < borders.first; i++) {
                                firstItems.add(bucket.items.get(i));
                            }
                            int firstFrom = (int)firstItems.get(0).charAt(0) - Global.FROM;
                            int firstTo = (int)firstItems.get(firstItems.size() - 1).charAt(0) - Global.FROM;
                            Bucket firstBucket = new Bucket(firstFrom, firstTo, prefix, firstItems);
                            ArrayList<String> secondItems = new ArrayList<>();
                            secondItems.add(bucket.items.get(borders.second));
                            for (int i = borders.second; i < bucket.items.size() - 1; i++) {
                                secondItems.add(bucket.items.get(i));
                            }
                            int secondFrom = (int)secondItems.get(0).charAt(0) - Global.FROM;
                            int secondTo = (int)secondItems.get(secondItems.size() - 1).charAt(0) - Global.FROM;
                            Bucket secondBucket = new Bucket(secondFrom, secondTo, prefix, secondItems);
                            for (int i = 0; i < firstFrom; i++) {
                                children[i] = null;
                            }
                            for (int i = firstFrom; i < firstTo + 1; i++) {
                                children[i] = firstBucket;
                            }
                            for (int i = firstTo + 1; i < secondFrom; i++) {
                                children[i] = null;
                            }
                            for (int i = secondFrom; i < secondTo + 1; i++) {
                                children[i] = secondBucket;
                            }
                            for (int i = secondTo + 1; i < children.length; i++) {
                                children[i] = null;
                            }
                        }
                        split = false;
                    }
                }
            } else {
                split = children[index].add(item.substring(1), (prefix + item.charAt(0)));
            }
            return split;
        } else {
            Pair borders = getNeighbouringNullPointers(children, index);
            ArrayList<String> items = new ArrayList<>();
            items.add(item);
            Bucket bucket = new Bucket(borders.first, borders.second, prefix, items);
            for (int i = borders.first; i < borders.second + 1; i++) {
                this.children[i] = bucket;
            }
            return false;
        }
    }

    private class Pair {
        public int first;
        public int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    public Pair getNeighbouringNullPointers(Node[] array, int index) {
        int first = index - 1;
        int second = index + 1;
        while (first > -1 && array[first] == null) {
            first--;
        }
        while (second < array.length && array[second] == null) {
            second++;
        }
        return new Pair(first + 1, second - 1);
    }

    public Pair getNeighbouringItems(ArrayList<String> array) {
        int first = 0;
        int second = array.size() - 1;
        boolean firstMove = true;
        while (array.get(first).charAt(0) != array.get(second).charAt(0)) {
            first++;
            firstMove = true;
            if(array.get(first).charAt(0) != array.get(second).charAt(0)) {
                second--;
                firstMove = false;
            }
        }
        if (firstMove) {
            first--;
        } else {
            second++;
        }
        return new Pair(first, second);
    }
}
