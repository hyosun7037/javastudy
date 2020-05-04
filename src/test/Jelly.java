package test;

//Jelly 클래스 생성
import java.awt.Image;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Jelly{
	Image image; // 젤리 이미지
	
	// 젤리들의 좌표와 크기
	int x;
	int y;
	int width;
	int height;
	
	// 젤리의 투명도 (0이 투명이며 255가 불투명)
	int alpha;
}