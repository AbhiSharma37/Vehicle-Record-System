import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
import javax.servlet.*;
import javax.servlet.http.*;

public class SketchServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Set the content type to image/png
        response.setContentType("image/png");

        // Create a buffered image
        int width = 500;
        int height = 500;
        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

        // Get the graphics context from the image
        Graphics2D g2d = bufferedImage.createGraphics();

        // Set background color and clear the canvas
        g2d.setColor(Color.WHITE);
        g2d.fillRect(0, 0, width, height);

        // Draw shapes (example: circle, rectangle, line)
        g2d.setColor(Color.BLUE);
        g2d.fillOval(150, 100, 200, 200); // Draw a blue circle

        g2d.setColor(Color.RED);
        g2d.drawRect(50, 50, 400, 400); // Draw a red rectangle

        g2d.setColor(Color.GREEN);
        g2d.drawLine(0, 0, 500, 500); // Draw a diagonal green line

        // Add text
        g2d.setColor(Color.BLACK);
        g2d.setFont(new Font("Arial", Font.BOLD, 24));
        g2d.drawString("Java Servlet Sketch", 120, 480);

        // Dispose of the graphics context
        g2d.dispose();

        // Write the image to the response output stream
        OutputStream out = response.getOutputStream();
        ImageIO.write(bufferedImage, "png", out);
        out.close();
    }
}
