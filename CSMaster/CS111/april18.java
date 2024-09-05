public class april18
{    
    public static void main(String[] args)
    {
        
    }
}

/*
 * a: What the method does is check how mny times n can go into m. If m was 15, n can go into it 3 times. 
 * The big O of the method has to be O(m/n).
 * 
 * b: big O of gradeBookAverage, studentAverage, and assignmentAverage
 * - O(mn)
 * - O(m)
 * - O(n)
 * 
 * public class GradeBook {
    private static int[][] grades;

    public GradeBook(int students, int exams) {
        grades = new int[students][exams];
    }
    public double gradeBookAverage() {
        double sum = 0;
        int min_index = 0;

        for (int[] studentGrades : grades) {
            // find the index of the lowest grade
            for (int i = 0; i < studentGrades.length; i++) {
                if (studentGrades[i] < studentGrades[min_index]){
                    min_index = i;
                }
            }
            // add all grades except the lowest
            for (int i = 0; i < studentGrades.length; i++) {
                if (i != min_index) sum += studentGrades[i];
            }
        }
        return sum / (grades.length * (grades[0].length - 1));
    }
    public double studentAverage(int student) {
        double sum = 0;
        for (int grade : grades[student]) {
            sum += grade;
        }
        return sum / grades[student].length;
    }
    public double assignmentAverage(int assignment) {
        double sum = 0;
        for (int[] studentGrades : grades) {
            sum += studentGrades[assignment];
        }
        return sum / grades.length;
    }
}

c: Trace the method for finding 1 in 15,2,8,1,17,5

a . 4 comparisons made
b . 3, O(1),O(n),O(n)

 */