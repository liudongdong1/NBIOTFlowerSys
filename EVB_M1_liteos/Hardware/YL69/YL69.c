#include "YL69.h"
#include "sys_init.h"
#include "stm32l4xx.h"
//#include "dwt.h"

void Init_YL69(void)
{
	HAL_ADCEx_Calibration_Start(&hadc1,ADC_SINGLE_ENDED);
}

UINT32 Get_YL69_Value(void){
	HAL_ADC_Start(&hadc1); 
	HAL_ADC_PollForConversion(&hadc1,10);                //��ѯת��
	if(HAL_IS_BIT_SET(HAL_ADC_GetState(&hadc1), HAL_ADC_STATE_REG_EOC))
            {
                return HAL_ADC_GetValue(&hadc1);
            }      
	return 0;                //�������һ��ADC1�������ת�����
}





