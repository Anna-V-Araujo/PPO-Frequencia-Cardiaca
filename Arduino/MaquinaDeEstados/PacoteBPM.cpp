// PacoteBPM.cpp

#include "PacoteBPM.h"

PacoteBPM::PacoteBPM(uint8_t id, uint8_t dia, uint8_t mes, uint16_t ano, uint8_t hora, uint8_t minuto, uint8_t seg, uint8_t bpm) {
	_id = id;
	_dia = dia;
	_mes = mes;
	_ano = ano;
	_hora = hora;
	_minuto = minuto;
	_seg = seg;
	_bpm = bpm;
}
