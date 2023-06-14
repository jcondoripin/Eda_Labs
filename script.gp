set terminal png
set output 'grafica.png'

set title "Gráfico de lectura de tiempos de algoritmos de ordenamiento"
set xlabel "Tamaño arreglo"
set ylabel "Tiempo (ns)"

# Establecer los colores y estilos para cada archivo
set style line 1 lc rgb "red"  pt 7 ps 0.5   # Archivo bubbleTimes.txt: Color rojo
set style line 2 lc rgb "blue"  pt 7 ps 0.5  # Archivo insertionTimes.txt: Color azul
set style line 3 lc rgb "green"  pt 7 ps 0.5 # Archivo mergeTimes.txt: Color verde

plot "bubbleTimes.txt" with points ls 1, \
     "insertionTimes.txt" with points ls 2, \
     "mergeTimes.txt" with points ls 3
