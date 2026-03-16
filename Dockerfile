# Imagem oficial Java 11 (Temurin)
FROM eclipse-temurin:11-jdk-jammy

# Diretório de trabalho
WORKDIR /app

# Copia os arquivos do projeto
COPY . .

# Compila todos os arquivos Java
RUN javac -d out $(find . -name "*.java")

# Comando de execução
CMD ["java", "-cp", "out", "Main"]