# Graph-Peaje-Solver 👨‍💻
# Planificación de Rutas en Colombia 🗺️

La problemática abordada en este proyecto es la planificación de rutas entre diversas ciudades en Colombia, considerando tanto las rutas principales con peajes como las rutas alternativas sin peajes.

El objetivo es encontrar la ruta menos costosa desde una ciudad de origen hasta una ciudad de destino, teniendo en cuenta los costos asociados a los peajes en las rutas principales y la disponibilidad de rutas alternativas sin costos adicionales o con costos menores.

## Algoritmo Utilizado 💻

Este problema se resuelve utilizando el algoritmo de Dijkstra para encontrar la ruta más económica en un grafo ponderado que representa las conexiones entre las ciudades. El algoritmo de Dijkstra es ampliamente utilizado para encontrar el camino más corto entre dos nodos en un grafo ponderado.

## Tecnologías Utilizadas 🛠️

El proyecto se implementó en Java utilizando la librería JGraphT, que proporciona implementaciones de varios algoritmos y estructuras de datos para trabajar con grafos. Se utilizó el algoritmo de Dijkstra de JGraphT para encontrar la ruta óptima entre las ciudades.

## Uso 🚀

Para usar este proyecto, sigue los siguientes pasos:

1. Clona este repositorio en tu máquina local.
2. Abre el proyecto en tu IDE preferido que admita Java.
3. Asegúrate de tener JGraphT configurado en tu proyecto.
4. Ejecuta el código y sigue las instrucciones para ingresar la ciudad de origen y la ciudad de destino.
5. El programa calculará y mostrará la ruta menos costosa entre las dos ciudades, considerando los peajes y las rutas alternativas.
