public class FloodFill {

    static void fill(int a[][], int r, int c, int newColor, int prevColor) {
        int rows = a.length;
        int columns = a[0].length;

        if (r < 0 || r >= rows || c < 0 || c >= columns)
            return;

        if (a[r][c] != prevColor)
            return;

        a[r][c] = newColor;

        fill(a, r - 1, c, newColor, prevColor);
        fill(a, r + 1, c, newColor, prevColor);
        fill(a, r, c - 1, newColor, prevColor);
        fill(a, r, c + 1, newColor, prevColor);

    }

    public static void main(String[] args) {
        // lets create a matrix with some random value
        // in flood fill we fill the node and all its directly connected nodes with the
        // new color

        int a[][] = { { 1, 1, 1, 1, 1, 1, 1, 1 }, { 1, 1, 1, 1, 0, 0, 2, 1 }, { 2, 2, 2, 1, 1, 2, 1, 2 },
                { 1, 0, 1, 0, 2, 1, 1, 1 }, { 1, 2, 3, 3, 2, 1, 1, 1 }, { 1, 1, 1, 1, 2, 2, 1, 2 },
                { 1, 1, 2, 1, 2, 1, 2, 1 }, { 1, 1, 1, 1, 0, 0, 1, 0 } };

        FloodFill.fill(a, 1, 2, 5, 1);
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(a[i][j]);
            }
            System.out.println();
        }
    }
}
