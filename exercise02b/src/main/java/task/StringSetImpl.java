package task;

import java.util.NoSuchElementException;

public class StringSetImpl implements StringSet {
    StringElement root;

    class StringElement {

        String value;
        StringElement right;
        StringElement left;


        StringElement(String v, StringElement l, StringElement r) {
            value = v;
            left = l;
            right = r;

        }


        StringElement remove(String v) {
            if (value.compareTo(v) < 0) {
                if (left != null){
                    left = left.remove(v);
                }
            } else if (value.compareTo(v) > 0) {
                if (right != null){
                    right = right.remove(v);
                }

            }
            else {
                if (right == null && left == null){
                    return  null;
                }
                if (left != null && right == null){
                    return left;
                }
                if (right != null && left == null){
                    return right;
                }
                if (left != null && right != null){
                    StringElement rightMini = right.findMin();
                    value = rightMini.value;
                    right = right.remove(rightMini.value);
                }
            }
            return this;
        }

        private StringElement findMin() {
            StringElement min = this;
            StringElement current = this;
            while (current != null) {
                if (current.value.compareTo(min.value) < 0) {
                    min = current;
                }
                current = current.left;
            }
            return min;
        }

        int size() {
          return 1 + (left == null ? 0 : left.size()) + (right == null ? 0 : right.size());
        }
        public String toString() {
            return value + (left == null ? "" : " " + left + " ") + (right == null ? "" : " " + right);
        }
    }
    @Override
    public boolean add(String s) {
        if(contains(s)){
            return false;
        }
        StringElement newElement = new StringElement(s, null, null);
        if (root == null) {
            root = newElement;
            return true;
        }
        StringElement current = root;
        while(current != null){
            if(current.value.compareTo(s) < 0){
                if(current.left != null){
                    current = current.left;
                }
                else{
                    current.left = newElement;
                    return true;
                }
            }
        }
        return false;

    }

    @Override
    public boolean contains(String s) {
        StringElement current = root;
        while (current != null) {
            if(current.value.equals(s)){
                return true;
            }
            else if (current.value.compareTo(s) > 0) {
                current = current.right;
            }
            else {
                current = current.left;
            }


    }
        return false;
    }

    @Override
    public String remove(String s) throws NoSuchElementException {
        if(!contains(s)){
            throw new NoSuchElementException("Element not found");
        }
        root = root.remove(s);
        return root.value;


    }

    @Override
    public int size() {
        if(root == null){
            return 0;
        }
        return root.size();
    }

    @Override
    public String toString() {
       if (root == null) {
           return "[]";
       }
       else {
           return "[" + root.toString() + "]";
       }
    }


}
