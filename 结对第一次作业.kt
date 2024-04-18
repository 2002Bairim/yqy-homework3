#include stdio.h
#include stdlib.h
#include string.h
#include time.h

const int MAXSIZE = 100000;定义排序样本最大长度

char FileName[50];

typedef struct data {
	int dataArray[MAXSIZE];临时存放排序样本的数组
	int length;
}dataArray;

void Init(dataArray array);		初始化，读取文件中的数字
void printArray(dataArray array);	打印数据序列
void bubbleSort(dataArray array);	冒泡排序
void selectSort(dataArray array);	选择排序
void insertSort(dataArray array);	直接插入排序
void shellSort(dataArray array);	希尔排序
void heapSort(dataArray array);	堆排序
void heapAdjust(dataArray array, int i, int length);	
void quickSort(dataArray array);	快速排序
void Qsort(dataArray array, int low, int high);	
int Partition(dataArray array, int low, int high);	

void ChangeDataFileName();
void Compare(dataArray array);

int Menu();

int main()
{
	int choose;
	dataArray array;
	clock_t start_time, end_time;
	double work_time;

	ChangeDataFileName();
	Init(&array);

	choose = Menu();
	while (choose != 0)
	{
		switch (choose) {
		case 1printArray(&array); break;
		case 2Compare(&array); break;
		case 3start_time = clock();获取程序开始运算时间
			for (int i = 0; i  50; i++)
			{
				Init(&array);
				bubbleSort(&array);
			}
			end_time = clock();获取程序结束运算时间

			work_time = (double)(end_time - start_time)  50;计算程序运算时间
			printArray(&array);
			printf(50次平均运行时间 %lf ms n, work_time  1000);
			break;


		case 4start_time = clock();
			for (int i = 0; i  50; i++)
			{
				Init(&array);
				selectSort(&array);
			}
			end_time = clock();
			work_time = (double)(end_time - start_time)  50;
			printArray(&array);
			printf(50次平均运行时间 %lf ms n, work_time  1000);
			break;


		case 5
			start_time = clock();
			for (int i = 0; i  50; i++)
			{
				Init(&array);
				insertSort(&array);
			}
			end_time = clock();
			work_time = (double)(end_time - start_time)  50;
			printArray(&array);
			printf(50次平均运行时间 %lf ms n, work_time  1000);
			break;

		case 6
			start_time = clock();
			for (int i = 0; i  50; i++)
			{
				Init(&array);
				shellSort(&array);
			}
			end_time = clock();
			work_time = (double)(end_time - start_time)  50;
			printArray(&array);
			printf(50次平均运行时间 %lf ms n, work_time  1000);
			break;


		case 7
			start_time = clock();
			for (int i = 0; i  50; i++)
			{
				Init(&array);
				heapSort(&array);
			}
			end_time = clock();
			work_time = (double)(end_time - start_time)  50;
			printArray(&array);
			printf(50次平均运行时间 %lf ms n, work_time  1000);
			break;

		case 8
			start_time = clock();
			for (int i = 0; i  50; i++)
			{
				Init(&array);
				quickSort(&array);
			}
			end_time = clock();
			work_time = (double)(end_time - start_time)  50;
			printArray(&array);
			printf(50次平均运行时间 %lf ms n, work_time  1000);
			break;
		case 9ChangeDataFileName(); break;
		case 10exit(0); break;
		defaultprintf(指令输入有误，请重新输入!n); break;

		}

		choose = Menu();
		Init(&array);
	}

	return 0;
}

初始化,读文件中数据
void Init(dataArray array)
{
	int i = 0, temp;
	FILE fp;

	从文本中读取排序样本
	if ((fp = fopen(FileName, r)) == NULL) {
		printf(文件读取失败！);
		return;
	}

	array-length = 0;初始化目标样本长度

	while ((fscanf(fp, %d, &temp)) != EOF)
	{
		array-dataArray[i] = temp;
		i++;
		array-length++;
	}

	fclose(fp);关闭文件
}

冒泡排序
void bubbleSort(dataArray array)
{
	int i, j, change;

	for (i = 0; i  array-length; i++) {
		for (j = array-length - 2; j = i; j--) {

			if (array-dataArray[j]  array-dataArray[j + 1]) {
				change = array-dataArray[j];
				array-dataArray[j] = array-dataArray[j + 1];
				array-dataArray[j + 1] = change;
			}
		}
	}

}

简单选择排序
void selectSort(dataArray array)
{
	int i, j, min, change;

	for (i = 0; i  array-length; i++) {
		min = i;
		for (j = i + 1; j  array-length; j++) {
			if (array-dataArray[min]  array-dataArray[j]) {
				若有小于基准的值，则更换基准
				min = j;
			}
		}
		if (i != min) {
			若min与i不想等，则说明找到这趟排序的最小值，交换
			change = array-dataArray[min];
			array-dataArray[min] = array-dataArray[i];
			array-dataArray[i] = change;
		}
	}
}


直接插入排序
void insertSort(dataArray array)
{
	int i, j, temp;

	for (i = 1; i  array-length; i++) {

		if (array-dataArray[i]  array-dataArray[i - 1]) {
			temp = array-dataArray[i];

			for (j = i - 1; array-dataArray[j]  temp; j--) {
				array-dataArray[j + 1] = array-dataArray[j];
			}

			array-dataArray[j + 1] = temp;
		}
	}
}


希尔排序
void shellSort(dataArray array)
{
	int i, j, temp;
	int increment = array-length;

	do {
		increment = increment  3 + 1;定义增量序列

		for (i = increment; i  array-length; i++) {

			if (array-dataArray[i]  array-dataArray[i - increment]) {
				temp = array-dataArray[i];用temp暂存

				for (j = i - increment; j = 0 && temp  array-dataArray[j]; j -= increment) {
					array-dataArray[j + increment] = array-dataArray[j];记录后移，寻找插入位置

				}
				array-dataArray[j + increment] = temp;插入

			}
		}


	} while (increment  1);
}


堆排序
void heapSort(dataArray array)
{
	int i, temp;

	for (i = array-length  2; i = 0; i--) {
		heapAdjust(array, i, array-length);将目标处理成一个大頂堆
	}

	for (i = array-length - 1; i  0; i--) {
		temp = array-dataArray[0];将堆顶记录和未经交换的子序列中的最后一个序列交换
		array-dataArray[0] = array-dataArray[i];
		array-dataArray[i] = temp;

		heapAdjust(array, 0, i - 1);将剩余序列重新调整为一个大頂堆
	}
}

将目标处理成大顶堆
void heapAdjust(dataArray array, int i, int length)
{
	int temp, j;

	temp = array-dataArray[i];
	for (j = 2  i; j  length; j = 2) {沿关键字较大的孩子结点向下筛选

		if (j  length && array-dataArray[j]  array-dataArray[j + 1]) {j为关键字中较大记录的下标
			++j;
		}
		if (temp = array-dataArray[j])
			break;

		array-dataArray[i] = array-dataArray[j];
		i = j;
	}
	array-dataArray[i] = temp;
}


快速排序
void quickSort(dataArray array)
{
	Qsort(array, 0, array-length - 1);
}

对目标样本中的子序列array(low...high)做快速排序
void Qsort(dataArray array, int low, int high)
{
	int pivot;

	if (low  high) {
		pivot = Partition(array, low, high);将dataArray[low...high]一分为二，并返回枢轴下标

		Qsort(array, low, pivot - 1);递归对低子表进行排序
		Qsort(array, pivot + 1, high);递归对高子表进行排序

	}
}


交换顺序表dataArray中子表的记录，使枢轴记录到位，并返回其所在位置
目标使枢轴两边的元素均不大于（小于）它
int Partition(dataArray array, int low, int high)
{
	int pivotKey, temp;

	pivotKey = array-dataArray[low];用子表的第一个记录作为枢轴记录

	while (low  high) {从两端交替向中间扫描

		while (low  high && array-dataArray[high] = array-dataArray[pivotKey]) {
			high--;
		}
		temp = array-dataArray[high];将比枢轴小的记录交换到低端
		array-dataArray[high] = array-dataArray[low];
		array-dataArray[low] = temp;

		while (low  high && array-dataArray[low] = array-dataArray[pivotKey]) {
			low++;
		}
		temp = array-dataArray[high];将比枢轴大的记录交换到高端
		array-dataArray[high] = array-dataArray[low];
		array-dataArray[low] = temp;

	}

	return low;返回枢轴所在的位置
}

void ChangeDataFileName()
{
	char temp[50];
	printf(请输入要读取的文件名n);
	scanf(%s, temp);

	FILE fp;

	从文本中读取排序样本
	if ((fp = fopen(temp, r)) == NULL) {
		printf(文件读取失败！);
		return;
	}

	strcpy(FileName, temp);
	fclose(fp);

	printf(读取文件%s成功!n, FileName);
}

void Compare(dataArray array)
{
	clock_t start_time, end_time;
	double work_time;

	start_time = clock();获取程序开始运算时间
	bubbleSort(array);
	end_time = clock();获取程序结束运算时间

	work_time = (double)end_time - start_time;计算程序运算时间
	printf(冒泡排序运行时间 %lf ms n, work_time  1000);

	Init(array);

	start_time = clock();
	selectSort(array);
	end_time = clock();
	work_time = (double)end_time - start_time;
	printf(选择排序运行时间 %lf ms n, work_time  1000);

	Init(array);

	start_time = clock();
	insertSort(array);
	end_time = clock();

	work_time = (double)end_time - start_time;
	printf(插入排序运行时间 %lf ms n, work_time  1000);

	Init(array);

	start_time = clock();
	shellSort(array);
	end_time = clock();

	work_time = (double)end_time - start_time;
	printf(希尔排序运行时间 %lf ms n, work_time  1000);

	Init(array);

	start_time = clock();
	heapSort(array);
	end_time = clock();

	work_time = (double)end_time - start_time;
	printf(堆排序运行时间 %lf ms n, work_time  1000);

	Init(array);

	start_time = clock();
	quickSort(array);
	end_time = clock();

	work_time = (double)end_time - start_time;
	printf(快速排序运行时间 %lf ms n, work_time  1000);
}

void printArray(dataArray array)
{
	int i;
	int Len;
	printf(数据总数%dn, array-length);
	if (array-length = 50)
	{
		Len = 50;
	}
	else
	{
		Len = array-length;
	}

	for (i = 0; i  Len; i++)
	{
		printf(%d , array-dataArray[i]);
	}
	printf( n);
}


int Menu()
{
	int choose;

	printf(排序算法性能比较程序n);
	printf(ttt1.显示序列内数据(最多显示前50个)n);
	printf(ttt2.性能比较n);
	printf(ttt3.冒泡法排序n);
	printf(ttt4.直接插入排序n);
	printf(ttt5.简单选择排序n);
	printf(ttt6.希尔排序n);
	printf(ttt7.堆排序n);
	printf(ttt8.快速排序n);
	printf(ttt9.读取其他文件n);
	printf(ttt10.退出程序n);
	printf(n);

	scanf(%d, &choose);
	return choose;
}