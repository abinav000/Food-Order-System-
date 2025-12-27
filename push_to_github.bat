@echo off
echo Initializing Git repository...
git init

echo Configuring Git user...
git config user.name "abinav000"
git config user.email "abinavsanjay45@gmail.com"

echo Adding all files...
git add .

echo Creating initial commit...
git commit -m "Initial commit: Food Order System Spring Boot application"

echo Adding remote origin...
git remote add origin https://github.com/abinav000/Food-Order-System-.git

echo Setting main branch...
git branch -M main

echo Pushing to GitHub...
git push -u origin main

echo Done! Repository available at: https://github.com/abinav000/Food-Order-System-
pause