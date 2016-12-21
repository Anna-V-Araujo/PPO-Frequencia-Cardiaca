################################################################################
# Automatically-generated file. Do not edit!
################################################################################

# Add inputs and outputs from these tool invocations to the build variables 
CPP_SRCS += \
C:\Users\thiag_000\Downloads\sloeber\arduinoPlugin\packages\arduino\hardware\avr\1.6.15\libraries\SoftwareSerial\src\SoftwareSerial.cpp 

LINK_OBJ += \
.\libraries\SoftwareSerial\src\SoftwareSerial.cpp.o 

CPP_DEPS += \
.\libraries\SoftwareSerial\src\SoftwareSerial.cpp.d 


# Each subdirectory must supply rules for building sources it contributes
libraries\SoftwareSerial\src\SoftwareSerial.cpp.o: C:\Users\thiag_000\Downloads\sloeber\arduinoPlugin\packages\arduino\hardware\avr\1.6.15\libraries\SoftwareSerial\src\SoftwareSerial.cpp
	@echo 'Building file: $<'
	@echo 'Starting C++ compile'
	"C:\Users\thiag_000\Downloads\sloeber\arduinoPlugin\tools\arduino\avr-gcc\4.9.2-atmel3.5.3-arduino2/bin/avr-g++" -c -g -Os -std=gnu++11 -fpermissive -fno-exceptions -ffunction-sections -fdata-sections -fno-threadsafe-statics -MMD -flto -mmcu=atmega328p -DF_CPU=16000000L -DARDUINO=10609 -DARDUINO_AVR_UNO -DARDUINO_ARCH_AVR   -I"C:\Users\thiag_000\Downloads\sloeber\arduinoPlugin\packages\arduino\hardware\avr\1.6.15\cores\arduino" -I"C:\Users\thiag_000\Downloads\sloeber\arduinoPlugin\packages\arduino\hardware\avr\1.6.15\variants\standard" -I"C:\Users\thiag_000\Downloads\sloeber\arduinoPlugin\packages\arduino\hardware\avr\1.6.15\libraries\SoftwareSerial" -I"C:\Users\thiag_000\Downloads\sloeber\arduinoPlugin\packages\arduino\hardware\avr\1.6.15\libraries\SoftwareSerial\src" -MMD -MP -MF"$(@:%.o=%.d)" -MT"$@" -D__IN_ECLIPSE__=1 -x c++ "$<" -o "$@"  -Wall
	@echo 'Finished building: $<'
	@echo ' '


