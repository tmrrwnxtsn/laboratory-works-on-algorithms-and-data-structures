#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <time.h>
#include <ctime>
#include <windows.h>
#include <stdio.h>
#include <psapi.h>
#include "pdh.h"

#define lengthArray 100

int array[lengthArray];
void firstTask();
void secondTask();
void thirdTask();
void printArray(int array[]);
void inputArray(int array[]);
void selectionSort(int array[]);
void mergeSort(int temporaryArray[], int lowerBound, int upperBound);
void merge(int temporaryArray[], int lowPtr, int highPtr, int upperBound);

int main() {

	firstTask();
	secondTask();
	thirdTask();

	{
		int x;
		scanf("%d", &x);
	}
}

// Задача 1: найти последний элемент массива, кратный 5
void firstTask() {

	inputArray(array);
	printf("Source array: ");
	printArray(array);

	for (int i = lengthArray - 1; i >= 0; i--) {
		if (array[i] % 5 == 0) {
			printf("\n%d - element, %d - element's index", array[i], i);
			return;
		}
	}
	printf("\nElement doesn't exist!");
}

// Задача 2: сортировка выбором
void secondTask() {

	inputArray(array);
	selectionSort(array);
}

int compare(const void* a, const void* b)
{
	return (*(int*)a - *(int*)b);
}

// Задача 3: сортировка слиянием
void thirdTask() {

	inputArray(array);
	int temporaryArray[lengthArray];
	mergeSort(temporaryArray, 0, lengthArray - 1);
}

// Функция, реализующая сортировку выбором
void selectionSort(int array[]) {

	for (int i = 0; i < lengthArray; i++) {
		int local_min_index = i;
		for (int j = i + 1; j < lengthArray; j++) {
			if (array[j] < array[local_min_index]) {
				local_min_index = j;
			}
		}
		int t = array[i];
		array[i] = array[local_min_index];
		array[local_min_index] = t;
	}
}

// Функция, реализующая сортировку слиянием
void mergeSort(int temporaryArray[], int lowerBound, int upperBound) {

	if (lowerBound == upperBound)
		return;
	else {
		int mid = (lowerBound + upperBound) / 2;
		mergeSort(temporaryArray, lowerBound, mid);
		mergeSort(temporaryArray, mid + 1, upperBound);
		merge(temporaryArray, lowerBound, mid + 1, upperBound);
	}
}

// Функция, реализующая слияние
void merge(int temporaryArray[], int lowPtr, int highPtr, int upperBound) {

	int k = 0;
	int lowerBound = lowPtr;
	int mid = highPtr - 1;
	int elementsNumber = upperBound - lowerBound + 1;

	while (lowPtr <= mid && highPtr <= upperBound) {
		if (array[lowPtr] < array[highPtr])
			temporaryArray[k++] = array[lowPtr++];
		else
			temporaryArray[k++] = array[highPtr++];
	}

	while (lowPtr <= mid)
		temporaryArray[k++] = array[lowPtr++];

	while (highPtr <= upperBound)
		temporaryArray[k++] = array[highPtr++];

	for (k = 0; k < elementsNumber; k++)
		array[lowerBound + k] = temporaryArray[k];
}

void printArray(int array[]) {
	for (int i = 0; i < lengthArray; i++)
		printf("%d ", array[i]);
}

void inputArray(int array[]) {
	for (int i = 0; i < lengthArray; i++)
		array[i] = rand() % 100;
}
