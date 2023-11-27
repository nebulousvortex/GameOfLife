package main.java.ru.vortex;

import static java.lang.Thread.sleep;


public class Model {
    static final int size = 5;

    /*
    * Start creating cells
    */
    public void start() throws InterruptedException {
        System.out.println("Введите начальную матрицу из true и false");

        Cell[][] cells;
        cells = makeFirstGen();
        for(Cell[] cellRow: cells){
            for(Cell cell: cellRow){
                cell.setCountNeighbours(cells);
            }
        }

        printGen(cells);
        View view = new View(cells);

        while (true) {
            sleep(1000);
            makeNextGen(cells);
            printGen(cells);
            view.setCells(cells);
            view.paintCells();
        }
    }

    /*
     * Generate first generation of cells
     */
    public static Cell[][] makeFirstGen(){
        Cell[][] cells = new Cell[][]{
                {new Cell(0, 0, true),new Cell(0, 1, true),new Cell(0, 2, false),new Cell(0, 3, true),new Cell(0, 4, true)},
                {new Cell(1, 0, true),new Cell(1, 1, false),new Cell(1, 2, true),new Cell(1, 3, false),new Cell(1, 4, true)},
                {new Cell(2, 0, true),new Cell(2, 1, false),new Cell(2, 2, false),new Cell(2, 3, false),new Cell(2, 4, true)},
                {new Cell(3, 0, true),new Cell(3, 1, true),new Cell(3, 2, false),new Cell(3, 3, true),new Cell(3, 4, true)},
                {new Cell(4, 0, false),new Cell(4, 1, false),new Cell(4, 2, false),new Cell(4, 3, false),new Cell(4, 4, false)},
                {new Cell(5, 0, false),new Cell(5, 1, false),new Cell(5, 2, false),new Cell(5, 3, false),new Cell(5, 4, false)},
                {new Cell(6, 0, false),new Cell(6, 1, false),new Cell(6, 2, false),new Cell(6, 3, false),new Cell(6, 4, false)},
                {new Cell(7, 0, false),new Cell(7, 1, false),new Cell(7, 2, false),new Cell(7, 3, false),new Cell(7, 4, false)},
                {new Cell(8, 0, false),new Cell(8, 1, false),new Cell(8, 2, false),new Cell(8, 3, false),new Cell(8, 4, false)}
        };
//        // На случай доработки в виде ввода в консоль
//        Scanner scanner = new Scanner(System.in);
//        Cell[][] cells = new Cell[size+3][size];
//        for (int i = 0; i < size+3; i++) {
//            for (int j = 0; j < size; j++) {
//                boolean alive = scanner.nextBoolean();
//                cells[i][j] = new Cell(i, j, alive);
//            }
//
//        }
        return cells;
    }

    /*
     * Generate next generation of cells
     */
    public static void makeNextGen(Cell[][] cells){
        for(Cell[] cellRow: cells){
            for(Cell cell: cellRow){
                cell.setCountNeighbours(cells);
            }
        }
        for(Cell[] cellRow: cells){
            for(Cell cell: cellRow){
                cell.killOrRevive();
            }
        }
    }

    /*
     * Print current generation of cells
     */
    public static void printGen(Cell[][] cells){
        for(Cell[] cellRow: cells){
            for(Cell cell: cellRow){
                System.out.print(cell.getValue());
                cell.nullifyNeighbours();
            }
            System.out.println();
        }
        System.out.println();
    }
}