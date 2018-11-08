################################################################################
# Automatically-generated file. Do not edit!
################################################################################

# Add inputs and outputs from these tool invocations to the build variables 
CPP_SRCS += \
../objects/Usb_Device.cpp 

OBJS += \
./objects/Usb_Device.o 

CPP_DEPS += \
./objects/Usb_Device.d 


# Each subdirectory must supply rules for building sources it contributes
objects/%.o: ../objects/%.cpp
	@echo 'Building file: $<'
	@echo 'Invoking: GCC C++ Compiler'
	g++ -I/usr/lib/jvm/java-9-openjdk-amd64/include -I/usr/lib/jvm/java-9-openjdk-amd64/include/linux -O3 -Wall -c -fmessage-length=0 -MMD -MP -MF"$(@:%.o=%.d)" -MT"$(@:%.o=%.d)" -o "$@" "$<"
	@echo 'Finished building: $<'
	@echo ' '


