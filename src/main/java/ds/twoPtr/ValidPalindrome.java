package ds.twoPtr;

public class ValidPalindrome {
    public static boolean isPalindrome(String s) {
        String cleanedString = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        int left = 0;
        int right = cleanedString.length() - 1;
        while (left < right) {
            if (cleanedString.charAt(left) != cleanedString.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        String s1 = "Madam";
        String s2 = "Sample Paper";
        System.out.println("Is \"" + s1 + "\" a palindrome? " + isPalindrome(s1));
        System.out.println("Is \"" + s2 + "\" a palindrome? " + isPalindrome(s2));
    }
}

