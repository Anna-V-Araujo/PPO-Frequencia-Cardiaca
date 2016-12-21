// PacoteConfirmacao.h

#ifndef PACOTECONFIRMACAO_H_
#define PACOTECONFIRMACAO_H_

#include <stdint.h>

class PacoteConfirmacao {
public:
	uint8_t _id;
	uint8_t _codigo; // 0 = ok e 1 = erro
	PacoteConfirmacao(uint8_t id, uint8_t codigo);
};

#endif /* PACOTECONFIRMACAO_H_ */
