import random

jugadores = [
    "Lionel Messi", "Cristiano Ronaldo", "Kylian Mbappé", "Erling Haaland",
    "Neymar Jr", "Kevin De Bruyne", "Luka Modric", "Vinícius Jr",
    "Robert Lewandowski", "Mohamed Salah"
]

# Creamos IDs del 1 al número de jugadores
ids = list(range(1, len(jugadores) + 1))

# Mezclamos los IDs y los jugadores juntos
random.shuffle(ids)
random.shuffle(jugadores)

with open("jugadores.txt", "w", encoding="utf-8") as f:
    for i, nombre in zip(ids, jugadores):
        valor = random.randint(10, 200)  # valor en millones
        f.write(f"{i};{nombre};{valor}\n")
