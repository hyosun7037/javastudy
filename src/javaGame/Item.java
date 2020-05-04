package javaGame;

import java.awt.Image;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

///////////////////////// 아이템 클래스 생성완료 ///////////////////
public class Item {
	private Image image;
	private int type;
	private int x;
	private int y;
}
