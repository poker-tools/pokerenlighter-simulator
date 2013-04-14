package org.javafling.pokerenlighter.gui;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Window;
import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Murzea Radu
 */
public class GUIUtilities
{
	private static final Font guifont = new Font ("Arial", Font.BOLD, 12);
	
	public static void applyFont (JPanel p, Font font)
	{
		Component[] comps = p.getComponents ();

		for (Component c : comps)
		{
			c.setFont (font);
		}
	}
	
	public static void applyFont (JPanel p)
	{
		Component[] comps = p.getComponents ();

		for (Component c : comps)
		{
			c.setFont (guifont);
		}
	}
	
	public static void applyComponentFont (JComponent c)
	{
		c.setFont (guifont);
	}
	
	public static void showErrorDialog (final Window parent, final String error, final String title)
	{
		if (SwingUtilities.isEventDispatchThread ())
		{
			JOptionPane.showMessageDialog (parent, error, title, JOptionPane.ERROR_MESSAGE);
		}
		else
		{
			SwingUtilities.invokeLater (new Runnable ()
			{
				@Override
				public void run ()
				{
					JOptionPane.showMessageDialog (parent, error, title, JOptionPane.ERROR_MESSAGE);
				}
			});
		}
	}
	
	public static void showOKDialog (final Window parent, final String message, final String title)
	{
		if (SwingUtilities.isEventDispatchThread ())
		{
			JOptionPane.showMessageDialog (parent, message, title, JOptionPane.INFORMATION_MESSAGE);
		}
		else
		{
			SwingUtilities.invokeLater (new Runnable ()
			{
				@Override
				public void run ()
				{
					JOptionPane.showMessageDialog (parent, message, title, JOptionPane.INFORMATION_MESSAGE);
				}
			});
		}
	}
	
	//returns the window's screen resolution.
	public static Dimension getResolution ()
	{
		//get the Toolkit of this instance
		Toolkit tk = Toolkit.getDefaultToolkit ();
		
		//get the screen size as Dimension object
		Dimension resolution = tk.getScreenSize ();

		/*int[] rez = new int[2];

		//extract integers from that Dimension object
		rez[0] = new Double (resolution.getWidth ()).intValue ();
		rez[1] = new Double (resolution.getHeight ()).intValue ();*/

		return resolution;
	}
	
	public static void setBorder (JComponent component, String text, int titleJustification)
	{
		component.setBorder (BorderFactory.createTitledBorder (BorderFactory.createEtchedBorder (),
															text,
															titleJustification,
															TitledBorder.TOP));
	}
}
