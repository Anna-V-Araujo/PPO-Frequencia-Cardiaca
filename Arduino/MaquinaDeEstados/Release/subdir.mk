################################################################################
# Automatically-generated file. Do not edit!
################################################################################

# Add inputs and outputs from these tool invocations to the build variables 
INO_SRCS += \
..\Interrupt.ino \
..\MaquinaDeEstados.ino \
..\PulseSensorAmped_Arduino_1dot4.ino 

CPP_SRCS += \
..\.ino.cpp \
..\PacoteBPM.cpp \
..\PacoteConfirmacao.cpp 

LINK_OBJ += \
.\.ino.cpp.o \
.\PacoteBPM.cpp.o \
.\PacoteConfirmacao.cpp.o 

INO_DEPS += \
.\Interrupt.ino.d \
.\MaquinaDeEstados.ino.d \
.\PulseSensorAmped_Arduino_1dot4.ino.d 

CPP_DEPS += \
.\.ino.cpp.d \
.\PacoteBPM.cpp.d \
.\PacoteConfirmacao.cpp.d 


# Each subdirectory must supply rules for building sources it contributes
.ino.cpp.o: ../.ino.cpp
	@echo 'Building file: $<'
	@echo 'Starting C++ compile'
	"C:\Users\thiag_000\Downloads\sloeber\arduinoPlugin\tools\arduino\avr-gcc\4.9.2-atmel3.5.3-arduino2/bin/avr-g++" -c -g -Os -std=gnu++11 -fpermissive -fno-exceptions -ffunction-sections -fdata-sections -fno-threadsafe-statics -MMD -flto -mmcu=atmega328p -DF_CPU=16000000L -DARDUINO=10609 -DARDUINO_AVR_UNO -DARDUINO_ARCH_AVR   -I"C:\Users\thiag_000\Downloads\sloeber\arduinoPlugin\packages\arduino\hardware\avr\1.6.15\cores\arduino" -I"C:\Users\thiag_000\Downloads\sloeber\arduinoPlugin\packages\arduino\hardware\avr\1.6.15\variants\standard" -I"C:\Users\thiag_000\Downloads\sloeber\arduinoPlugin\packages\arduino\hardware\avr\1.6.15\libraries\SoftwareSerial" -I"C:\Users\thiag_000\Downloads\sloeber\arduinoPlugin\packages\arduino\hardware\avr\1.6.15\libraries\SoftwareSerial\src" -MMD -MP -MF"$(@:%.o=%.d)" -MT"$@" -D__IN_ECLIPSE__=1 -x c++ "$<" -o "$@"  -Wall
	@echo 'Finished building: $<'
	@echo ' '

BufferCircular.cpp.o: ../BufferCircular.cpp
	@echo 'Building file: $<'
	@echo 'Starting C++ compile'
	"C:\Users\thiag_000\Downloads\sloeber\arduinoPlugin\tools\arduino\avr-gcc\4.9.2-atmel3.5.3-arduino2/bin/avr-g++" -c -g -Os -std=gnu++11 -fpermissive -fno-exceptions -ffunction-sections -fdata-sections -fno-threadsafe-statics -MMD -flto -mmcu=atmega328p -DF_CPU=16000000L -DARDUINO=10609 -DARDUINO_AVR_UNO -DARDUINO_ARCH_AVR   -I"C:\Users\thiag_000\Downloads\sloeber\arduinoPlugin\packages\arduino\hardware\avr\1.6.15\cores\arduino" -I"C:\Users\thiag_000\Downloads\sloeber\arduinoPlugin\packages\arduino\hardware\avr\1.6.15\variants\standard" -I"C:\Users\thiag_000\Downloads\sloeber\arduinoPlugin\packages\arduino\hardware\avr\1.6.15\libraries\SoftwareSerial" -I"C:\Users\thiag_000\Downloads\sloeber\arduinoPlugin\packages\arduino\hardware\avr\1.6.15\libraries\SoftwareSerial\src" -MMD -MP -MF"$(@:%.o=%.d)" -MT"$@" -D__IN_ECLIPSE__=1 -x c++ "$<" -o "$@"  -Wall
	@echo 'Finished building: $<'
	@echo ' '

Interrupt.o: ../Interrupt.ino
	@echo 'Building file: $<'
	@echo 'Starting C++ compile'
	"C:\Users\thiag_000\Downloads\sloeber\arduinoPlugin\tools\arduino\avr-gcc\4.9.2-atmel3.5.3-arduino2/bin/avr-g++" -c -g -Os -std=gnu++11 -fpermissive -fno-exceptions -ffunction-sections -fdata-sections -fno-threadsafe-statics -MMD -flto -mmcu=atmega328p -DF_CPU=16000000L -DARDUINO=10609 -DARDUINO_AVR_UNO -DARDUINO_ARCH_AVR   -I"C:\Users\thiag_000\Downloads\sloeber\arduinoPlugin\packages\arduino\hardware\avr\1.6.15\cores\arduino" -I"C:\Users\thiag_000\Downloads\sloeber\arduinoPlugin\packages\arduino\hardware\avr\1.6.15\variants\standard" -I"C:\Users\thiag_000\Downloads\sloeber\arduinoPlugin\packages\arduino\hardware\avr\1.6.15\libraries\SoftwareSerial" -I"C:\Users\thiag_000\Downloads\sloeber\arduinoPlugin\packages\arduino\hardware\avr\1.6.15\libraries\SoftwareSerial\src" -MMD -MP -MF"$(@:%.o=%.d)" -MT"$@" -D__IN_ECLIPSE__=1 -x c++ "$<" -o "$@"  -Wall
	@echo 'Finished building: $<'
	@echo ' '

MaquinaDeEstados.o: ../MaquinaDeEstados.ino
	@echo 'Building file: $<'
	@echo 'Starting C++ compile'
	"C:\Users\thiag_000\Downloads\sloeber\arduinoPlugin\tools\arduino\avr-gcc\4.9.2-atmel3.5.3-arduino2/bin/avr-g++" -c -g -Os -std=gnu++11 -fpermissive -fno-exceptions -ffunction-sections -fdata-sections -fno-threadsafe-statics -MMD -flto -mmcu=atmega328p -DF_CPU=16000000L -DARDUINO=10609 -DARDUINO_AVR_UNO -DARDUINO_ARCH_AVR   -I"C:\Users\thiag_000\Downloads\sloeber\arduinoPlugin\packages\arduino\hardware\avr\1.6.15\cores\arduino" -I"C:\Users\thiag_000\Downloads\sloeber\arduinoPlugin\packages\arduino\hardware\avr\1.6.15\variants\standard" -I"C:\Users\thiag_000\Downloads\sloeber\arduinoPlugin\packages\arduino\hardware\avr\1.6.15\libraries\SoftwareSerial" -I"C:\Users\thiag_000\Downloads\sloeber\arduinoPlugin\packages\arduino\hardware\avr\1.6.15\libraries\SoftwareSerial\src" -MMD -MP -MF"$(@:%.o=%.d)" -MT"$@" -D__IN_ECLIPSE__=1 -x c++ "$<" -o "$@"  -Wall
	@echo 'Finished building: $<'
	@echo ' '

PacoteBPM.cpp.o: ../PacoteBPM.cpp
	@echo 'Building file: $<'
	@echo 'Starting C++ compile'
	"C:\Users\thiag_000\Downloads\sloeber\arduinoPlugin\tools\arduino\avr-gcc\4.9.2-atmel3.5.3-arduino2/bin/avr-g++" -c -g -Os -std=gnu++11 -fpermissive -fno-exceptions -ffunction-sections -fdata-sections -fno-threadsafe-statics -MMD -flto -mmcu=atmega328p -DF_CPU=16000000L -DARDUINO=10609 -DARDUINO_AVR_UNO -DARDUINO_ARCH_AVR   -I"C:\Users\thiag_000\Downloads\sloeber\arduinoPlugin\packages\arduino\hardware\avr\1.6.15\cores\arduino" -I"C:\Users\thiag_000\Downloads\sloeber\arduinoPlugin\packages\arduino\hardware\avr\1.6.15\variants\standard" -I"C:\Users\thiag_000\Downloads\sloeber\arduinoPlugin\packages\arduino\hardware\avr\1.6.15\libraries\SoftwareSerial" -I"C:\Users\thiag_000\Downloads\sloeber\arduinoPlugin\packages\arduino\hardware\avr\1.6.15\libraries\SoftwareSerial\src" -MMD -MP -MF"$(@:%.o=%.d)" -MT"$@" -D__IN_ECLIPSE__=1 -x c++ "$<" -o "$@"  -Wall
	@echo 'Finished building: $<'
	@echo ' '

PacoteConfirmacao.cpp.o: ../PacoteConfirmacao.cpp
	@echo 'Building file: $<'
	@echo 'Starting C++ compile'
	"C:\Users\thiag_000\Downloads\sloeber\arduinoPlugin\tools\arduino\avr-gcc\4.9.2-atmel3.5.3-arduino2/bin/avr-g++" -c -g -Os -std=gnu++11 -fpermissive -fno-exceptions -ffunction-sections -fdata-sections -fno-threadsafe-statics -MMD -flto -mmcu=atmega328p -DF_CPU=16000000L -DARDUINO=10609 -DARDUINO_AVR_UNO -DARDUINO_ARCH_AVR   -I"C:\Users\thiag_000\Downloads\sloeber\arduinoPlugin\packages\arduino\hardware\avr\1.6.15\cores\arduino" -I"C:\Users\thiag_000\Downloads\sloeber\arduinoPlugin\packages\arduino\hardware\avr\1.6.15\variants\standard" -I"C:\Users\thiag_000\Downloads\sloeber\arduinoPlugin\packages\arduino\hardware\avr\1.6.15\libraries\SoftwareSerial" -I"C:\Users\thiag_000\Downloads\sloeber\arduinoPlugin\packages\arduino\hardware\avr\1.6.15\libraries\SoftwareSerial\src" -MMD -MP -MF"$(@:%.o=%.d)" -MT"$@" -D__IN_ECLIPSE__=1 -x c++ "$<" -o "$@"  -Wall
	@echo 'Finished building: $<'
	@echo ' '

PulseSensorAmped_Arduino_1dot4.o: ../PulseSensorAmped_Arduino_1dot4.ino
	@echo 'Building file: $<'
	@echo 'Starting C++ compile'
	"C:\Users\thiag_000\Downloads\sloeber\arduinoPlugin\tools\arduino\avr-gcc\4.9.2-atmel3.5.3-arduino2/bin/avr-g++" -c -g -Os -std=gnu++11 -fpermissive -fno-exceptions -ffunction-sections -fdata-sections -fno-threadsafe-statics -MMD -flto -mmcu=atmega328p -DF_CPU=16000000L -DARDUINO=10609 -DARDUINO_AVR_UNO -DARDUINO_ARCH_AVR   -I"C:\Users\thiag_000\Downloads\sloeber\arduinoPlugin\packages\arduino\hardware\avr\1.6.15\cores\arduino" -I"C:\Users\thiag_000\Downloads\sloeber\arduinoPlugin\packages\arduino\hardware\avr\1.6.15\variants\standard" -I"C:\Users\thiag_000\Downloads\sloeber\arduinoPlugin\packages\arduino\hardware\avr\1.6.15\libraries\SoftwareSerial" -I"C:\Users\thiag_000\Downloads\sloeber\arduinoPlugin\packages\arduino\hardware\avr\1.6.15\libraries\SoftwareSerial\src" -MMD -MP -MF"$(@:%.o=%.d)" -MT"$@" -D__IN_ECLIPSE__=1 -x c++ "$<" -o "$@"  -Wall
	@echo 'Finished building: $<'
	@echo ' '


