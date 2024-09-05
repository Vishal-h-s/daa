package daa;


/*You are part of a team developing a climate monitoring system that records temperature readings 
from various sensors placed across different regions. 
The temperature data is recorded every hour and stored in a sorted list, 
where each entry represents the temperature at a specific time.

The system occasionally needs to analyze periods of extreme weather, 
such as heatwaves or cold spells. 
To do this, it must identify the first and last occurrences of a specific temperature 
within the recorded data, which helps in understanding the duration of these extreme conditions.

Your task is to implement a module 
that finds the first and last positions of a given temperature in the SORTED list of temperature readings.

NOTE:
If the target temperature is not found in the list, the function should return [-1, -1].
The solution should be efficient, as the temperature data could be extensive.

Input Format:
-------------
Line-1 : Comma(,) separated list of numbers, represents temperature
Line-2 : A number, target value

Output Format:
--------------
Line-1 : Comma(,) seperated numbers, represents indexes, check sample output

Sample input1:
-------------
15, 18, 18, 21, 21, 21, 24, 30
21

Sample output1:
--------------
[3, 5]

Sample input2:
-------------
10, 20, 30, 40, 50, 60, 70, 80
60

Sample output2:
--------------
[5, 5]
*/

import java.util.Scanner;

class d1p1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        Integer target = sc.nextInt();
        sc.close();
        String[] arr = input.split(",");
        int n = arr.length;

        int mini = -1, maxi = -1;

        // Find the minimum index of the target
        int start = 0, end = n - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            int midValue = Integer.parseInt(arr[mid].trim());

            if (target < midValue) {
                end = mid - 1;
            } else if (target > midValue) {
                start = mid + 1;
            } else {
                mini = mid;
                // Continue searching in the left half
                end = mid - 1;
            }
        }

        // Find the maximum index of the target
        start = 0;
        end = n - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            int midValue = Integer.parseInt(arr[mid].trim());

            if (target < midValue) {
                end = mid - 1;
            } else if (target > midValue) {
                start = mid + 1;
            } else {
                maxi = mid;
                // Continue searching in the right half
                start = mid + 1;
            }
        }

        System.out.println("[" + mini + ", " + maxi + "]");
    }
}
