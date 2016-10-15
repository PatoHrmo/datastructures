package bsttree;

public class BstTree<K extends Comparable<K>, T> {
	private BstNode<K,T> root;
	public BstTree() {
		root = null;
	}
	
	public boolean insert(K key,T newData) {
		if(root == null) {
			root = new BstNode<>(key, newData);;
			return true;
		}
		BstNode<K,T> actualNode = root;
		while(true) {
			if(actualNode.compareKeys(key)<0) {
				if(actualNode.left==null) {
					actualNode.left = new BstNode<>(key, newData);;
					return true;
				} else {
					actualNode = actualNode.left;
					continue;
				}
			}
			if(actualNode.compareKeys(key)>0) {
				if(actualNode.right==null) {
					actualNode.right = new BstNode<>(key, newData);
					return true;
				} else {
					actualNode = actualNode.right;
					continue;
				}
			}
			return false;
		}	
	}
	public T find(K key) {
		if(root == null) return null;
		BstNode<K, T> actual = root;
		while (true) {
			if(actual.compareKeys(key)==0) return actual.getData();
			if(actual.compareKeys(key)<0) {
				if(actual.left == null) return null;
				else actual = actual.left;
			}
			if(actual.compareKeys(key)>0) {
				if(actual.right == null) return null;
				else actual = actual.right;
			}
		}
	} 
	private void inOrder(BstNode<K,T> node) {
		if(node!=null) {
			this.inOrder(node.left);
			System.out.println(node.toString() + System.lineSeparator());
			this.inOrder(node.right);
		}
	}
	public void inOrder() {
		if(root==null)  return;
		this.inOrder(root);
	}
}
