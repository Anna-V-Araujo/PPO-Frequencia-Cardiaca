// BufferCircular.cpp

#include "BufferCircular.h"

template <class T> BufferCircular<T>::BufferCircular() {
    _size = SIZE;
    //_data = (T *)malloc(size * sizeof(T));
    _start = 0;
    _end = 0;

}

template <class T> T BufferCircular<T>::read() {
    T chr;
    if (_end == _start) {
        return 0;
    }
    chr = _data[_start];
    _start = (_start + 1) % _size;
    return chr;
}

template <class T> void BufferCircular<T>::write(T d) {
    uint32_t newEnd = (_end + 1) % _size;
    if (newEnd != _start) {
        _data[_end] = d;
        _end = newEnd;
    }
}

template <class T> int BufferCircular<T>::available() {
    return (_size + _start - _end) % _size;
}

template <class T> void BufferCircular<T>::clear() {
    _start = _end = 0;
    memset(_data, 0, sizeof(_data));
}

template <class T> T BufferCircular<T>::getEntry(uint32_t p) {
    if (p >= _size) {
        return 0;
    }
    return _data[p];
}

template <class T> uint32_t BufferCircular<T>::getStart() {
    return _start;
}

template <class T> uint32_t BufferCircular<T>::getEnd() {
    return _end;
}
