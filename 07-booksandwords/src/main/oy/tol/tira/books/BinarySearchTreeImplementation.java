package oy.tol.tira.books;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Locale;



public class BinarySearchTreeImplementation implements Book {
    private class WordCount {
        WordCount(String word2, int i) {
            word = "";
            count = 0;
        }
        String word;
        int count;
    }
    
    public static int UniqueWordCount = 0;
    private int TotalWordCount = 0;
    private int IgnoredWordsTotal = 0;
    public static int MaxProbingSteps = 0;
    private static final int MAX_WORD_LEN = 100;
    public static int indexOfWordCount=0;
    private WordCount root=null;
    public static WordCount[] words = null;
    private String wordsToIgnoreFile = null;
    private WordFilter filter = null;
    private String bookFile = null;
    
    @Override
    public void setSource(String fileName, String ignoreWordsFile) throws FileNotFoundException {
        boolean success = false;
        if (checkFile(fileName)) {
            bookFile = fileName;
            if (checkFile(ignoreWordsFile)) {
                wordsToIgnoreFile = ignoreWordsFile;
                success = true;
            }
        }
        if (!success) {
            throw new FileNotFoundException("Cannot find the specified files");
        }
    }

    private boolean checkFile(String fileName) {
        if (fileName != null) {
            File file = new File(fileName);
            if (file.exists() && !file.isDirectory()) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void countUniqueWords() throws IOException, OutOfMemoryError {
        if (bookFile == null || wordsToIgnoreFile == null) {
            throw new IOException("There is no file specified");
        }
        UniqueWordCount = 0;
        TotalWordCount = 0;
        IgnoredWordsTotal = 0;
        filter = new WordFilter();
        filter.readFile(wordsToIgnoreFile);
        FileReader reader = new FileReader(bookFile, StandardCharsets.UTF_8);
        int i;
        int[] array = new int[MAX_WORD_LEN];
        int currentIndex = 0;
        while ((i = reader.read()) != -1) {
            if (Character.isLetter(i)) {
                array[currentIndex] = i;
                currentIndex++;
            } else {
                if (currentIndex > 0) {
                    String word = new String(array, 0, currentIndex).toLowerCase(Locale.ROOT);
                    currentIndex = 0;
                    addToWords(new WordCount(word, 1));
                }
            }
        }
        if (currentIndex > 1) {
            String word = new String(array, 0, currentIndex).toLowerCase(Locale.ROOT);
            addToWords(new WordCount(word, 1));
        }
        reader.close();
    }

    private void addToWords(WordCount wordcount) throws OutOfMemoryError {
        if (!filter.shouldFilter(wordcount.word) && wordcount.word.length() >= 2) {
            if(root==null){
                root=wordcount;
                UniqueWordCount++;
            }
            else{
                root.insert(wordcount, wordcount.hash);
            }
            TotalWordCount++;
        }
        else {
            IgnoredWordsTotal++;
        }
    }

    private void Arrayreallocate(int nSize) throws OutOfMemoryError {
        WordCount[] newWords = new WordCount[nSize];
        for (int index = 0; index < nSize; index++) {
            newWords[index] = words[index];
        }
        words = newWords;
    }


    @Override
    public void report() {
        words=new WordCount[UniqueWordCount];
        if (words == null) {
            System.out.println("No report!");
            return;
        }
        System.out.println("List words from one file: " + bookFile);
        System.out.println("Ignor words from one file: " + wordsToIgnoreFile);
        System.out.println("Sort the results...");
        System.out.println("...sorted.");
        for (int index = 0; index < 100; index++) {
            if (index>=words.length) {
                break;
            }
            String word = String.format("%-20s", words[index].word).replace(' ', '.');
            System.out.format("%4d. %s %6d%n", index + 1, word, words[index].count);
        }
        System.out.println("The total count of word " + TotalWordCount);
        System.out.println("The count of unique words:    " + UniqueWordCount);
        System.out.println("The count of words to ignore:    " + filter.ignoreWordCount());
        System.out.println("Ignored words count:      " + IgnoredWordsTotal);
        System.out.println("Data of the BSearchTree: ");
        System.out.println("Max ProbingSteps: " + MaxProbingSteps);
    }


    

    @Override
    public void close() {
        root = null;
        bookFile = null;
        wordsToIgnoreFile = null;
        if (filter != null) {
            filter.close();
        }
        filter = null;
    
    }

    

    @Override
    public int getUniqueWordCount() {
        return UniqueWordCount;
    }

    @Override
    public int getTotalWordCount() {
        return TotalWordCount;
    }

    @Override
    public String getWordInListAt(int position) {
        if (words != null && position >= 0 && position < UniqueWordCount) {
            return words[position].word;
        }
        return null;
    }

    @Override
    public int getWordCountInListAt(int position) {
        if (words != null && position >= 0 && position < UniqueWordCount) {
            return words[position].count;
        }
        return -1;
    }
}