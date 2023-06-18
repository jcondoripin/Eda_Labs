set terminal png
set output 'grafica.png'

set title "Gráfico de lectura de tiempos del ordenamiento por insercion"
set xlabel "Tamaño arreglo"
set ylabel "Tiempo (ns)"

# Establecer los colores y estilos para cada archivo
set style line 2 lc rgb "green"  pt 7 ps 0.5  # Archivo insertionTimes.txt: Color azul

plot "insertionTimes.txt" with points ls 2
