package edu.towson.cis.cosc442.project2.rectangle;

// TODO: Auto-generated Javadoc
/**
 * The Class Rectangle.
 */
public class Rectangle {
	
	/** The two points of the rectangle. */
	private Point firstPoint, secondPoint;
	
	/**
	 * Instantiates a new rectangle.
	 *
	 * @param firstPoint the p1
	 * @param secondPoint the p2
	 */
	Rectangle(Point firstPoint, Point secondPoint) {
		this.firstPoint = firstPoint;
		this.secondPoint = secondPoint;
	}
	
	/**
	 * Gets the area.
	 *
	 * @return the area
	 */
	public Double getArea() {
		return Math.abs((secondPoint.xCoord - firstPoint.xCoord) * (secondPoint.yCoord - firstPoint.yCoord));
	}
	
	/**
	 * Gets the diagonal.
	 *
	 * @return the diagonal
	 */
	public Double getDiagonal() {
		return Math.sqrt(Math.pow((secondPoint.xCoord - firstPoint.xCoord), 2) + Math.pow((secondPoint.yCoord - firstPoint.yCoord), 2));
	}
}
