package ds.twoPtr;

public class ReverseString {

    public static void main(String[] args) {
        String cleanedString = "A man, A cow & A dog.";
        reverseString(cleanedString);
        reverseStringTwoPtrAppproach(cleanedString);
        reverseWordsWithSplit(cleanedString);
    }

    // if you want words to be reversed as well.
    static void reverseString(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        int size = str.length() - 1;
        for (int i = size - 1; i > 0; i--) {
            stringBuilder.append(str.charAt(i));
        }
        System.out.println(stringBuilder);
    }

    static void reverseWordsWithSplit(String str) {
        String[] strArray = str.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        int size = strArray.length;
        for (int i = size - 1; i >= 0; i--) {
            stringBuilder.append(strArray[i]).append(" ");
        }
        System.out.println(stringBuilder);
    }

    static void reverseStringTwoPtrAppproach(String s) {
        // Convert the string to a character array
        char[] charArray = s.toCharArray();
        // Use two pointers to swap characters from the beginning and end
        int left = 0;
        int right = charArray.length - 1;
        while (left < right) {
            // Swap characters at the left and right pointers
            char temp = charArray[left];
            charArray[left] = charArray[right];
            charArray[right] = temp;
            // Move the pointers towards the center
            left++;
            right--;
        }
        System.out.println(new String(charArray));
    }
}

