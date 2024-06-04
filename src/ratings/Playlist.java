package ratings;

import ratings.datastructures.BinaryTreeNode;
import ratings.datastructures.Comparator;
import ratings.datastructures.LinkedListNode;
import java.util.ArrayList;

public class Playlist {
    private BinaryTreeNode<Song> root;
    private Comparator<Song> comparator;

    public Playlist(Comparator<Song> comparator) {
        this.comparator = comparator;
        this.root = null;
    }

    public void addSong(Song value) {
        if (this.root == null) {
            this.root = new BinaryTreeNode<>(value, null, null);
        } else {
            this.insertHelper(this.root, value);
        }
    }

    private void insertHelper(BinaryTreeNode<Song> node, Song toInsert) {
        if (this.comparator.compare(toInsert, node.getValue())) {
            if (node.getLeft() == null) {
                node.setLeft(new BinaryTreeNode<>(toInsert, null, null));
            } else {
                insertHelper(node.getLeft(), toInsert);
            }
        } else {
            if (node.getRight() == null) {
                node.setRight(new BinaryTreeNode<>(toInsert, null, null));
            } else {
                insertHelper(node.getRight(), toInsert);
            }
        }
    }

    public BinaryTreeNode<Song> getSongTree(){
        return root;
    }

    public LinkedListNode<Song> getSongList(){
        return getSongList(root);
    }


    public LinkedListNode<Song> getSongList(BinaryTreeNode<Song> tree){
        if (tree == null) {
            return null;
        }

        LinkedListNode<Song> leftNode = getSongList(tree.getLeft());
        LinkedListNode<Song> currentNode = new LinkedListNode<>(tree.getValue(),null);
        LinkedListNode<Song> rightNode = getSongList(tree.getRight());

        if (leftNode != null) {
            LinkedListNode<Song> nextNode = leftNode;
            while (nextNode.getNext() != null) {
                nextNode = nextNode.getNext();
            }
            nextNode.setNext(currentNode);
        } else {
            leftNode = currentNode;
        }
        currentNode.setNext(rightNode);
        return leftNode;
    }


}
