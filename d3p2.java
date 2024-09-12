/* 
Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements. 
The operation should be performed in-place without making a copy of the array, and the time complexity should be minimized.

Constraints:
------------
nums contains only integers.
You must maintain the relative order of the non-zero elements.
The operation must be done in-place with O(1) extra space.

Input Format:
-------------
Line-1: An integer, size of the array
Line-2 to n: A single array of integers nums with at least one element.

Output Format:
-------------
Line-1: The modified input array nums, where all zeros are moved to the end while maintaining the relative order of the non-zero elements.

Sample Input-1:
----------------
5
0 1 0 3 12

Sample Output-1:
----------------
1 3 12 0 0

Sample Input-2:
---------------
1
0

Sample Output-2:
-----------------
0

 */
package daa;

import java.util.Scanner;

class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }sc.close();
       

        int count = 0;
        for (int i = 0, j = 0; j < n;) {
            if (arr[j] != 0) {
                j++;
            }
            if (arr[i] != 0)
                i++;
            // else preserve i i.e.firt occurence of 0

            if (arr[j] == 0) {
                // find next non zero
                while (arr[j] == 0 && j < n)
                    j++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                count++;
                // swap with first 0
            }
        }

        for (int i = 0; i < n - 1; i++) {
            System.out.print(arr[i]);
        }
        System.out.println(arr[n - 1]);

    }
}