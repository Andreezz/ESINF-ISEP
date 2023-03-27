/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esinf;

import java.util.*;

/**
 * @param <E> Generic type of buffer element
 * @author DEI-ISEP
 */
public class PriorityBufferPrinter<E extends Document> implements Iterable<E> {

    private final ArrayList<E> buffer;
    private final Integer maxSize;

    /**
     * Creates a new PriorityBufferPrinter with a maximum buffer size maxSize
     *
     * @param maxSize maximum buffer size
     */
    public PriorityBufferPrinter(Integer maxSize) {
        buffer = new ArrayList<>(); // Diamond notation: the type can be inferred by the compiler
        this.maxSize = maxSize;
    }

    /**
     * Calculates the size occupied by the docs in the buffer
     *
     * @return size occupied
     */

    private Integer usedSize() {
        int sizedoc = 0;
        for (E doc : buffer) {
            sizedoc += doc.getSize();
        }
        return sizedoc;
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Adds a document to the buffer.Documents are added using a numeric priority system, being FIFO when priorities are equal.
     *
     * @param doc the document to be added to the buffer
     *: @return true if the buffer has space, false otherwise
     */
    public Boolean addDocument(E doc) {
        if (usedSize() + doc.getSize() > maxSize) {
            return false;
        }
        //insere com as prioridades
        ListIterator<E> it = buffer.listIterator();
        while (it.hasNext()) {
            if (it.next().compareTo(doc) > 0) {
                it.previous();
                it.add(doc);
                return true;
            }
        }
        it.add(doc);//insere o primeiro documento no buffer
        // throw new UnsupportedOperationException("Not supported yet.");
        return true;
    }

    /**
     * Gets the next document in the queue.
     *
     * @return The next document in the queue
     */
    public E getDocument() {
        if (buffer.isEmpty()) {
            return null;

        }
        E doc = buffer.get(0);
        buffer.remove(0);
        return doc;
        // throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Deletes a document from the buffer (if it exists), given a name and an author
     *
     * @param name   the name of the Document
     * @param author the author of the Document
     * @return true if the document existed, false otherwise
     */
    public Boolean delDocument(String name, String author) {
        Iterator<E> it = buffer.iterator();
        while (it.hasNext()) {
            E doc = it.next();
            if (doc.getName().equals(name) && doc.getAuthor().equals(author)) {
                it.remove();
                return true;
            }
        }
        //se nada for removido irá sair false
        return false;
        // throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Deletes all the documents which are superior to a given size
     *s
     * @param size the size above which documents will be deleted
     * @return true if there is at least one Document size
     */
    public Boolean delDocumentsAbove(Integer size) {
        Iterator<E> it = buffer.iterator();
        boolean deldocs= false;
        while (it.hasNext()) {
            E doc = it.next();
            if (doc.getSize()>= size){
                it.remove();
                deldocs= true;

            }
        }
        //throw new UnsupportedOperationException("Not supported yet.");
        return deldocs;
    }
/*
    public Map <Integer, LinkedList<Integer>> ksublist(LinkedList<Integer> list, ArrayList<Integer> centers) {
        Map<Integer, LinkedList<Integer>> sublist = new HashMap<>();
        for (Integer center : centers) {
            sublist.put(center, new LinkedList<>());
            for (Integer elem : list) {
                Integer absdist = Integer.MAX_VALUE;
                Integer namecenter = 0;
                for (Integer center : centers) {
                    if (absdist > Math.abs(elem.centre)) {
                        absdist = Math.abs(elem.centre);
                        namecenter = center;
                    }
                }
            }
        }
        return sublist;
    }
    */


    @Override
    public String toString() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Iterator<E> iterator() {
        return buffer.iterator();
    }

}
