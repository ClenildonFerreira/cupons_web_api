#!/bin/bash
echo "🚀 Iniciando Deploy do Backend (Java API)..."
git pull
docker compose down --rmi all
docker compose build --no-cache
docker compose up -d --force-recreate
echo "✅ Deploy do Backend finalizado com sucesso!"
