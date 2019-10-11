#ifndef __LIGHT_H__
#define __LIGHT_H__
/* 包含头文件 ----------------------------------------------------------------*/
#include "stm32l4xx_hal.h"

/* 类型定义 ------------------------------------------------------------------*/
/* 宏定义 --------------------------------------------------------------------*/
 
void Init_Light(void);					
void Turn_Up_Light(UINT32 num);		
void Turn_Down_Light(UINT32 num);
#endif





