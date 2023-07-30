//package at.spengergasse.graphene_POS_T;
//
//import javafx.scene.Group;
//import javafx.scene.control.Button;
//import javafx.scene.control.Label;
//import javafx.scene.image.Image;
//import javafx.scene.image.ImageView;
//import javafx.scene.layout.*;
//import javafx.scene.paint.Paint;
//import javafx.scene.shape.Rectangle;
//import javafx.scene.text.Font;
//import javafx.scene.text.FontWeight;
//import javafx.scene.text.Text;
//import model.*;
//import model.Square;
//import model.BoardException;
//import java.util.ArrayList;
//import java.util.Objects;
//
//
//public class RootBorderPane extends BorderPane {
//
//	private GridPane gridPane;
//	private Square square;
//	private Group groupChessBoard, groupPieces;
//	private Rectangle rectangle;
//	private HBox hBox;
//	private FlowPane flowPanetop, flowPaneBottm;
//	private VBox vBoxLeft, vBoxRight;
//	private ImageView ivPiece;
//	private Image image;
//	private Label label;
//	private Button buttonMove;
//	private Board chessboard = TestBoard.initBoard();
//	private Player playerOne, playerTwo;
//	private ArrayList<Piece> p1Piece, p2Piece;
//
//	final Knight knightw = new Knight("Knight",
//			3,
//			Board.getSquares().get(62),
//			new ImageView(new Image(Objects.requireNonNull(getClass().getResourceAsStream("knight.png")))),
//			new Image(Objects.requireNonNull(getClass().getResourceAsStream("knight.png")))
//	);
//	final Knight knightw2 = new Knight("Knight",
//			3,
//			Board.getSquares().get(57),
//			new ImageView(new Image(Objects.requireNonNull(getClass().getResourceAsStream("knight.png")))),
//			new Image(Objects.requireNonNull(getClass().getResourceAsStream("knight.png")))
//	);
//
//	final Bishop bishopw = new Bishop("Bishop",
//			3,
//			Board.getSquares().get(61),
//			new ImageView(new Image(Objects.requireNonNull(getClass().getResourceAsStream("bishop.png")))),
//			new Image(Objects.requireNonNull(getClass().getResourceAsStream("bishop.png")))
//	);
//	final Bishop bishopw2 =new Bishop("Bishop",
//			3,
//			Board.getSquares().get(58),
//			new ImageView(new Image(Objects.requireNonNull(getClass().getResourceAsStream("bishop.png")))),
//			new Image(Objects.requireNonNull(getClass().getResourceAsStream("bishop.png")))
//	);
//	final Rook rookw = new Rook("Bishop",
//			4,
//			Board.getSquares().get(63),
//			new ImageView(new Image(Objects.requireNonNull(getClass().getResourceAsStream("rook.png")))),
//			new Image(Objects.requireNonNull(getClass().getResourceAsStream("rook.png")))
//	);
//	final Rook rookw2 = new Rook("Bishop",
//			4,
//			Board.getSquares().get(56),
//			new ImageView(new Image(Objects.requireNonNull(getClass().getResourceAsStream("rook.png")))),
//			new Image(Objects.requireNonNull(getClass().getResourceAsStream("rook.png")))
//	);
//	final Qeen queenw = new Qeen("Qeen",
//			8,
//			Board.getSquares().get(60),
//			new ImageView(new Image(Objects.requireNonNull(getClass().getResourceAsStream("queen.png")))),
//			new Image(Objects.requireNonNull(getClass().getResourceAsStream("queen.png")))
//	);
//	final King kingw = new King("King",
//			100,
//			Board.getSquares().get(59),
//			new ImageView(new Image(Objects.requireNonNull(getClass().getResourceAsStream("king.png")))),
//			new Image(Objects.requireNonNull(getClass().getResourceAsStream("king.png")))
//	);
//	final Pawn pawnW1 =  new Pawn("Pawn",
//			1,
//			Board.getSquares().get(55),
//			new ImageView(new Image(Objects.requireNonNull(getClass().getResourceAsStream("pawn.png")))),
//			new Image(Objects.requireNonNull(getClass().getResourceAsStream("pawn.png")))
//	);
//	final Pawn pawnW2 =  new Pawn("Pawn",
//			1,
//			Board.getSquares().get(54),
//			new ImageView(new Image(Objects.requireNonNull(getClass().getResourceAsStream("pawn.png")))),
//			new Image(Objects.requireNonNull(getClass().getResourceAsStream("pawn.png")))
//	);
//	final Pawn pawnW3 =  new Pawn("Pawn",
//			1,
//			Board.getSquares().get(53),
//			new ImageView(new Image(Objects.requireNonNull(getClass().getResourceAsStream("pawn.png")))),
//			new Image(Objects.requireNonNull(getClass().getResourceAsStream("pawn.png")))
//	);
//	final Pawn pawnW4 =  new Pawn("Pawn",
//			1,
//			Board.getSquares().get(52),
//			new ImageView(new Image(Objects.requireNonNull(getClass().getResourceAsStream("pawn.png")))),
//			new Image(Objects.requireNonNull(getClass().getResourceAsStream("pawn.png")))
//	);
//	final Pawn pawnW5 =  new Pawn("Pawn",
//			1,
//			Board.getSquares().get(51),
//			new ImageView(new Image(Objects.requireNonNull(getClass().getResourceAsStream("pawn.png")))),
//			new Image(Objects.requireNonNull(getClass().getResourceAsStream("pawn.png")))
//	);
//	final Pawn pawnW6 =  new Pawn("Pawn",
//			1,
//			Board.getSquares().get(50),
//			new ImageView(new Image(Objects.requireNonNull(getClass().getResourceAsStream("pawn.png")))),
//			new Image(Objects.requireNonNull(getClass().getResourceAsStream("pawn.png")))
//	);
//	final Pawn pawnW7 =  new Pawn("Pawn",
//			1,
//			Board.getSquares().get(49),
//			new ImageView(new Image(Objects.requireNonNull(getClass().getResourceAsStream("pawn.png")))),
//			new Image(Objects.requireNonNull(getClass().getResourceAsStream("pawn.png")))
//	);
//	final Pawn pawnW8 =  new Pawn("Pawn",
//			1,
//			Board.getSquares().get(48),
//			new ImageView(new Image(Objects.requireNonNull(getClass().getResourceAsStream("pawn.png")))),
//			new Image(Objects.requireNonNull(getClass().getResourceAsStream("pawn.png")))
//	);
//
//	final Knight knightB = new Knight("Black Knight",
//			3,
//			Board.getSquares().get(6),
//			new ImageView(new Image(Objects.requireNonNull(getClass().getResourceAsStream("bknight.png")))),
//			new Image(Objects.requireNonNull(getClass().getResourceAsStream("bknight.png")))
//	);
//	final Knight knightB2 = new Knight("Black Knight",
//			3,
//			Board.getSquares().get(1),
//			new ImageView(new Image(Objects.requireNonNull(getClass().getResourceAsStream("bknight.png")))),
//			new Image(Objects.requireNonNull(getClass().getResourceAsStream("bknight.png")))
//	);
//	final Bishop bishopB = new Bishop("Black Bishop",
//			3,
//			Board.getSquares().get(5),
//			new ImageView(new Image(Objects.requireNonNull(getClass().getResourceAsStream("bbishop.png")))),
//			new Image(Objects.requireNonNull(getClass().getResourceAsStream("bbishop.png")))
//	);
//	final Bishop bishopB2 = new Bishop("Black Bishop",
//			3,
//			Board.getSquares().get(2),
//			new ImageView(new Image(Objects.requireNonNull(getClass().getResourceAsStream("bbishop.png")))),
//			new Image(Objects.requireNonNull(getClass().getResourceAsStream("bbishop.png")))
//	);
//	final Rook rookB = new Rook("Black Bishop",
//			4,
//			Board.getSquares().get(7),
//			new ImageView(new Image(Objects.requireNonNull(getClass().getResourceAsStream("brook.png")))),
//			new Image(Objects.requireNonNull(getClass().getResourceAsStream("bbishop.png")))
//	);
//	final Rook rookB2 = new Rook("Black Bishop",
//			4,
//			Board.getSquares().get(0),
//			new ImageView(new Image(Objects.requireNonNull(getClass().getResourceAsStream("brook.png")))),
//			new Image(Objects.requireNonNull(getClass().getResourceAsStream("bbishop.png")))
//	);
//	final Qeen queenB = new Qeen("Black Qeen",
//			8,
//			Board.getSquares().get(4),
//			new ImageView(new Image(Objects.requireNonNull(getClass().getResourceAsStream("bqueen.png")))),
//			new Image(Objects.requireNonNull(getClass().getResourceAsStream("bbishop.png")))
//	);
//	final King kingB = new King("Black King",
//			100,
//			Board.getSquares().get(3),
//			new ImageView(new Image(Objects.requireNonNull(getClass().getResourceAsStream("bking.png")))),
//			new Image(Objects.requireNonNull(getClass().getResourceAsStream("bking.png")))
//	);
//	final Pawn pawnB1 = new Pawn("Black Pawn",
//			1,
//			Board.getSquares().get(15),
//			new ImageView(new Image(Objects.requireNonNull(getClass().getResourceAsStream("bpawn.png")))),
//			new Image(Objects.requireNonNull(getClass().getResourceAsStream("bpawn.png")))
//	);
//
//	final Pawn pawnB2 =  new Pawn("Black Pawn",
//			1,
//			Board.getSquares().get(14),
//			new ImageView(new Image(Objects.requireNonNull(getClass().getResourceAsStream("bpawn.png")))),
//			new Image(Objects.requireNonNull(getClass().getResourceAsStream("bpawn.png")))
//	);
//	final Pawn pawnB3 =  new Pawn("Black Pawn",
//			1,
//			Board.getSquares().get(13),
//			new ImageView(new Image(Objects.requireNonNull(getClass().getResourceAsStream("bpawn.png")))),
//			new Image(Objects.requireNonNull(getClass().getResourceAsStream("bpawn.png")))
//	);
//	final Pawn pawnB4 =  new Pawn("Black Pawn",
//			1,
//			Board.getSquares().get(12),
//			new ImageView(new Image(Objects.requireNonNull(getClass().getResourceAsStream("bpawn.png")))),
//			new Image(Objects.requireNonNull(getClass().getResourceAsStream("bpawn.png"))));
//	final Pawn pawnB5 =  new Pawn("Black Pawn",
//			1,
//			Board.getSquares().get(11),
//			new ImageView(new Image(Objects.requireNonNull(getClass().getResourceAsStream("bpawn.png")))),
//			new Image(Objects.requireNonNull(getClass().getResourceAsStream("bpawn.png")))
//	);
//	final Pawn pawnB6 =  new Pawn("Black Pawn",
//			1,
//			Board.getSquares().get(10),
//			new ImageView(new Image(Objects.requireNonNull(getClass().getResourceAsStream("bpawn.png")))),
//			new Image(Objects.requireNonNull(getClass().getResourceAsStream("bpawn.png")))
//	);
//	final Pawn pawnB7 =  new Pawn("Black Pawn",
//			1,
//			Board.getSquares().get(9),
//			new ImageView(new Image(Objects.requireNonNull(getClass().getResourceAsStream("bpawn.png")))),
//			new Image(Objects.requireNonNull(getClass().getResourceAsStream("bpawn.png")))
//	);
//	final Pawn pawnB8 =  new Pawn("Black Pawn",
//			1,
//			Board.getSquares().get(8),
//			new ImageView(new Image(Objects.requireNonNull(getClass().getResourceAsStream("bpawn.png")))),
//			new Image(Objects.requireNonNull(getClass().getResourceAsStream("bpawn.png")))
//	);
//
//
//
//	public RootBorderPane() throws BoardException {
//		initComponents();
//		addHandlers();
//	}
//	private void initComponents() throws BoardException {
//		playerOne = new Player("PlayerOne", p1Piece,  "White");
//		playerTwo = new Player("PlayerTwp", p2Piece,  "Black");
//
//		playerOne.setPieces(p1Piece);
//		playerTwo.setPieces(p2Piece);
//
//
//
//		//Board board = new Board();
//		flowPanetop = new FlowPane();
//			flowPanetop.setMinHeight(100);
//		vBoxLeft = new VBox();
//			vBoxLeft.setPrefWidth(200);
// 		hBox = new HBox();
//			vBoxRight = new VBox();
//		vBoxRight.setPrefWidth(200);
//		flowPaneBottm = new FlowPane();
//			flowPanetop.setMinHeight(100);
//
//		buttonMove = new Button("move");
//		vBoxRight.getChildren().add(buttonMove);
//
//		addPlayerOneList(knightw2);
//		addPlayerOneList(knightw);
//		addPlayerOneList(bishopw);
//		addPlayerOneList(bishopw2);
//		addPlayerOneList(rookw);
//		addPlayerOneList(rookw2);
//		addPlayerOneList(queenw);
//		addPlayerOneList(kingw);
//		addPlayerOneList(pawnW1);
//		addPlayerOneList(pawnW2);
//		addPlayerOneList(pawnW3);
//		addPlayerOneList(pawnW4);
//		addPlayerOneList(pawnW5);
//		addPlayerOneList(pawnW6);
//		addPlayerOneList(pawnW7);
//		addPlayerOneList(pawnW8);
//
//
//		addPlayerTwoList(knightB);
//		addPlayerTwoList(knightB2);
//		addPlayerTwoList(bishopB);
//		addPlayerTwoList(bishopB2);
//		addPlayerTwoList(rookB);
//		addPlayerTwoList(rookB2);
//		addPlayerTwoList(queenB);
//		addPlayerTwoList(kingB);
//		addPlayerTwoList(pawnB1);
//		addPlayerTwoList(pawnB2);
//		addPlayerTwoList(pawnB3);
//		addPlayerTwoList(pawnB4);
//		addPlayerTwoList(pawnB5);
//		addPlayerTwoList(pawnB6);
//		addPlayerTwoList(pawnB7);
//		addPlayerTwoList(pawnB8);
//
//		playerOne.setPieces(p1Piece);
//		playerTwo.setPieces(p2Piece);
//
//		setTop(flowPanetop);
//		setLeft(vBoxLeft);
//		setCenter(hBox);
//		setRight(vBoxRight);
//		setBottom(flowPaneBottm);
//	}
//
//	private void addHandlers() throws BoardException {
//		drawChessBoard();
//		drawPiece();
//		drawPieceb();
//		buttonMove.setOnAction(event -> {
//			try {
//				move(pawnW5);
//			} catch (BoardException e) {
//				throw new RuntimeException(e);
//			}
//		});
//	}
//
//	public void addPlayerOneList(Piece piece){
//		if (!piece.getPieceName().contains("B"))
//			p1Piece.add(piece);
//	}
//
//	public void addPlayerTwoList(Piece piece){
//		if (piece.getPieceName().contains("B"))
//			p2Piece.add(piece);
//	}
//	public void drawChessBoard() throws BoardException {
//		Board chessboard = TestBoard.initBoard();
//		groupChessBoard = new Group();
//
//		int counter = 0;
//		groupChessBoard.prefHeight(600);
//		groupChessBoard.prefWidth(600);
//		int x = 600;
//		int y = -300;
//		for (Square sq : chessboard.getSquares()) {
//			counter++;
//			Rectangle rectangle = new Rectangle(x,y,90, 90);//Paint.valueOf(String.valueOf(sq.getColor())
//			rectangle.fillProperty().set(Paint.valueOf(String.valueOf(sq.getColor())));
//			rectangle.setX(x);
//			rectangle.setY(y);
//			sq.setRectangle(rectangle);
//
//
//			x -= 90;
//			if (counter == 8 || counter == 16 || counter == 24 || counter == 32 || counter == 40 || counter == 48 || counter == 56) {
//				y += 90;
//				x = 600;
//			}
//			 sq.getRectangle().setAccessibleText(sq.getSquareName());
//			Text text = new Text(sq.getSquareName());
//			if ( sq.getCol() == 1) {
//				text = new Text(sq.getSquareName().substring(1, 2));
//			} else if (sq.getRow() == 1){
//				text = new Text(sq.getSquareName().substring(0, 1));
//			} else if (sq.getCol() == 1 && sq.getRow() == 1) {
//				text = new Text((sq.getSquareName().substring(0, 2)));
//			} else {
//				text = new Text(sq.getSquareName().substring(0, 0));
//			}
//
//			text.setFont(Font.font("Arial", FontWeight.BOLD, 10));
//			text.setX(sq.getRectangle().getX() + 2);
//			text.setY(sq.getRectangle().getY() + 88);
//			groupChessBoard.getChildren().add(rectangle);
//			groupChessBoard.getChildren().addAll(text);
//
//
//		}
//
//
//		hBox.getChildren().add(groupChessBoard);
//	}
//
//	public void drawPiece() {
//		ImageView imView = new ImageView();
//		int counter = 0;
//		int x = 600;
//		int y = -300;
//		for (Piece p : playerOne.getPieces()) {
//			imView = p.getImageView();
//			imView.setPreserveRatio(true);
//			imView.setFitWidth(80);
//			counter++;
//			System.out.println(imView.getX());
//			x -= 90;
//			if (counter == 8) {
//				y += 90;
//				x = 600;
//			}
//			System.out.println(x);
//			System.out.println(y);
//			imView.setX(x);
//			imView.setY(y);
//		}
//		groupChessBoard.getChildren().add(imView);
//	}
//
//	public void drawPieceb() {
//		ImageView imView = new ImageView();
//		int counter = 0;
//		int x = 600;
//		int y = -300;
//		for (Piece p : playerTwo.getPieces()) {
//			imView = p.getImageView();
//			imView.setPreserveRatio(true);
//			imView.setFitWidth(80);
//			counter++;
//			System.out.println(imView.getX());
//			x -= 90;
//			if (counter == 8) {
//				y += 90;
//				x = 600;
//			}
//			System.out.println(x);
//			System.out.println(y);
//			imView.setX(x);
//			imView.setY(y);
//
//		}
//		groupChessBoard.getChildren().add(imView);
//
//	}
//
//	public void drawthis(Piece piece) {
//		ImageView imView = piece.getImageView();
//		imView.setPreserveRatio(true);
//		imView.setFitWidth(80);
//		double x = piece.getCurrentPositionSquare().getRectangle().getX() + 5;
//		double y = piece.getCurrentPositionSquare().getRectangle().getY() + 5;
//		System.out.println(x);
//		System.out.println(y);
//		imView.setX(x);
//		imView.setY(y);
//		groupChessBoard.getChildren().add(imView);
//	}
//
//	public void move(Piece piece) throws BoardException {
//		ArrayList<Square> moveNew = piece.possiblePos();
//		Square aktuell = piece.getCurrentPositionSquare();
//		Square k = moveNew.get(0);
//		piece.setCurrentPositionSquare(k);
//		k.setPiece(piece);
//		System.out.println(piece.getCurrentPositionSquare().getSquareName());
//		groupChessBoard.getChildren().remove(piece.getImageView());
//		drawthis(piece);
//		piece.possiblePos().clear();
//	}
//
//}
//
//
//
//
