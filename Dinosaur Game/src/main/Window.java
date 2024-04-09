package main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Window extends JFrame
{
	private static JFrame frame;
	private Canvas canvas;
	public static Input keys;
	
	public Window()
	{
		frame = new JFrame("Dinosaur Game");
		frame.setVisible(true);
		frame.setSize(800, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setBackground(Color.white);
		frame.setResizable(false);
		canvas = new Canvas();
		canvas.setPreferredSize(new Dimension(800, 800));
		canvas.setMaximumSize(new Dimension(800, 800));
		canvas.setMinimumSize(new Dimension(800, 800));
		canvas.setFocusable(false);
		frame.add(canvas);
		frame.pack();
		keys = new Input();
		frame.addKeyListener(keys);
	}
	
	public Canvas getCanvas()
	{
		return canvas;
	}
	
	public static JFrame getWindow()
	{
		return frame;
	}
}
