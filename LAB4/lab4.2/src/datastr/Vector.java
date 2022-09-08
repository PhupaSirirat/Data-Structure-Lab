package datastr;

interface Vector {

    int length();

    double magnitude();

    double get(int index);

    void set(int index, double value);

    Vector add(Vector v);

    Vector substract(Vector v);

    double dot(Vector v);

    Vector multiply(double c);

//    Lab 4.2
    Vector multiply(Matrix v);

}
