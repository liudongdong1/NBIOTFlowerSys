#include "Light.h"
#include "sys_init.h"
#include "stm32l4xx.h"
//#include "dwt.h"

int pwm_val=0;

void Init_Light(void)
{
		HAL_TIM_PWM_Start(&htim2, TIM_CHANNEL_1);
}
void Turn_Up_Light(UINT32 num){
	if(pwm_val<999)
		pwm_val+=num;
	__HAL_TIM_SET_COMPARE(&htim2, TIM_CHANNEL_1, pwm_val);
}

void Turn_Down_Light(UINT32 num){
	if(pwm_val>0)
		pwm_val-=num;
	__HAL_TIM_SET_COMPARE(&htim2, TIM_CHANNEL_1, pwm_val);
}





