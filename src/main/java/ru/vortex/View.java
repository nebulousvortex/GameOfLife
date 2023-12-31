package main.java.ru.vortex;

import java.awt.*;
import javax.swing.*;

public class View {
    private final MainWindow window;
    View(Cell[][] cells){
        this.window = new MainWindow(cells);
    }

    public void paintCells() {
        window.repaint();
    }

    public void setCells(Cell[][] cells) {
        this.window.setCells(cells);
    }
}

class MainWindow extends JFrame{
    private Cell[][] cells;
    MainWindow(Cell[][] cells) {
        super("GameOfLife on screen");
        setSize(220,160);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        this.cells = cells;
    }

    /*
     * Update cells array
     */
    public void setCells(Cell[][] cells) {
        this.cells = cells;
    }

    /*
     * Paint current generation of cells
     */
    public void paint(Graphics g) {
        super.paint(g);

        for (Cell[] cellRow : cells) {
            for(Cell cell: cellRow) {
                int x = cell.getX();
                int y = cell.getY();
                g.setColor(cell.getColor());
                g.fillOval((x+1)*20, (y+2)*20, 20, 20);
            }
        }
    }
}