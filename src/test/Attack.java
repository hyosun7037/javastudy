package test;

//Jelly Ŭ���� ����
import java.awt.Image;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Attack{
	Image image; // ���� �̹���
	
	// ��ֹ����� ��ǥ�� ũ��
	int x;
	int y;
	int width;
	int height;
	
	// ��ֹ��� ������ (0�� �����̸� 255�� ������)
	int alpha;
}