# 🖥️ Sistemas Operativos: Procesos y Virtualización de CPU

## 1. 🎯 Fundamentos de Procesos

### 1.1 📝 Definición y Naturaleza
Un proceso es un programa en ejecución, que a diferencia de un programa estático almacenado en el disco, representa una entidad activa dentro del sistema operativo.

### 1.2 🧩 Componentes del Estado de Máquina
Los procesos mantienen un estado de máquina que incluye:

- **💾 Memoria**:
  ```
  Proceso
  ├── 📜 Código (Text)
  ├── 📊 Datos (Data)
  ├── 📚 Heap (Dynamic)
  └── 🔄 Stack
  ```

- **⚡ Registros**:
  ```
  Registros
  ├── PC (Program Counter)
  ├── SP (Stack Pointer)
  ├── GP (General Purpose)
  └── FR (Flags Register)
  ```

- **🔌 Recursos de E/S**:
  ```
  E/S
  ├── 📁 Archivos
  ├── 🌐 Red
  └── 🎮 Dispositivos
  ```

## 2. 🔄 Ciclo de Vida de un Proceso

### 2.1 🚀 Creación de Procesos

#### Fórmulas de Memoria:
```math
Memoria_Total = Código + Datos_Estáticos + Heap + Stack

Stack_Frame_Size = Variables_Locales + Parámetros + Return_Address

Heap_Size(t) = Heap_Initial + Σ(malloc - free)
```

### 2.2 📊 Estados del Proceso

Las probabilidades de transición entre estados se pueden calcular como:

```math
P(transición) = λ × Δt

donde:
λ = tasa de transición
Δt = intervalo de tiempo
```

## 3. ⚙️ Virtualización de CPU

### 3.1 🛠️ Métricas de Rendimiento

#### Fórmulas Fundamentales:

1. **Utilización de CPU**:
```math
CPU_Utilization = \frac{Tiempo_Ocupado}{Tiempo_Total} × 100\%
```

2. **Throughput**:
```math
Throughput = \frac{Número\_de\_Procesos}{Tiempo\_Total}
```

3. **Tiempo de Respuesta Normalizado**:
```math
R = \frac{T_{respuesta}}{T_{servicio}}
```

4. **Eficiencia del Planificador**:
```math
E = \frac{T_{útil}}{T_{útil} + T_{overhead}}
```

### 3.2 🎯 Algoritmos de Planificación

#### Round Robin
```math
Quantum_óptimo = \sqrt{2 × T_{cambio\_contexto} × T_{promedio\_CPU}}
```

#### MLFQ (Multi-Level Feedback Queue)
```math
Prioridad_nueva = Prioridad_actual + \frac{CPU\_burst}{Quantum} + Aging\_factor
```

#### CFS (Completely Fair Scheduler)
```math
vruntime = \frac{runtime × NICE_0_LOAD}{proceso.weight}

donde:
NICE_0_LOAD = 1024 (constante)
proceso.weight = función del nice value
```

## 4. 🔧 Gestión Avanzada

### 4.1 📈 Métricas de Calidad de Servicio (QoS)

```math
QoS_{score} = w_1R + w_2T + w_3U

donde:
R = tiempo de respuesta normalizado
T = throughput normalizado
U = utilización normalizada
w_i = pesos de importancia
```

### 4.2 🎮 Control de Admisión
```math
P(admisión) = \begin{cases} 
1 & \text{si } \frac{recursos\_disponibles}{recursos\_requeridos} ≥ threshold \\
0 & \text{en otro caso}
\end{cases}
```

## 5. 📊 Fórmulas de Análisis

### 5.1 Rendimiento
1. **Tiempo de Turnaround**:
```math
T_{turnaround} = T_{completion} - T_{arrival}
```

2. **Tiempo de Espera**:
```math
T_{wait} = T_{turnaround} - T_{burst}
```

3. **Tiempo de Respuesta**:
```math
T_{response} = T_{first\_run} - T_{arrival}
```

### 5.2 Predicción de Burst
```math
\tau_{n+1} = \alpha \times t_n + (1-\alpha) \times \tau_n

donde:
\tau = predicción
t = valor actual
\alpha = factor de suavizado (0 ≤ \alpha ≤ 1)
```

## 6. 🔍 Monitoreo y Análisis

### 6.1 📉 Indicadores Clave (KPIs)

1. **Load Average**:
```math
LoadAvg_{1min} = \frac{\sum Procesos_{running} + \sum Procesos_{uninterruptible}}{intervalo}
```

2. **Índice de Fragmentación**:
```math
Fragmentación = 1 - \frac{Mayor\_Bloque\_Continuo}{Memoria\_Libre\_Total}
```

### 6.2 🎯 Objetivos de Rendimiento

- Latencia < 100ms para procesos interactivos
- Utilización de CPU > 80% para batch
- Throughput > X procesos/segundo
- Tiempo de respuesta < Y ms

## 7. 📚 Referencias y Recursos

- 📖 "Operating System Concepts" - Silberschatz
- 🔬 "Modern Operating Systems" - Tanenbaum
- 🌐 Documentación del Kernel Linux
- 📑 Papers académicos relevantes

## 8. 🎓 Consejos para Exámenes

1. 📝 Practicar cálculos de métricas
2. 🎯 Entender los trade-offs de cada algoritmo
3. 🧮 Memorizar fórmulas fundamentales
4. 🔄 Comprender los diagramas de estado
5. 💡 Resolver problemas de planificación
