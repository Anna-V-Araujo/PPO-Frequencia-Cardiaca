// PacoteBPM.h

#ifndef PACOTEBPM_H_
#define PACOTEBPM_H_

#include <stdint.h>


class PacoteBPM {
public:
	uint8_t _id;
	uint8_t _dia;
	uint8_t _mes;
	uint16_t _ano;
	uint8_t _hora;
	uint8_t _minuto;
	uint8_t _seg;
	uint8_t _bpm;
	PacoteBPM(uint8_t id, uint8_t dia, uint8_t mes, uint16_t ano, uint8_t hora, uint8_t minuto, uint8_t seg, uint8_t bpm);
};

#endif /* PACOTEBPM_H_ */
