@echo off
setlocal

REM Try to find Git executable
set "GIT_CMD="
if exist "C:\Program Files\Git\bin\git.exe" (
    set "GIT_CMD=C:\Program Files\Git\bin\git.exe"
) else if exist "C:\Program Files (x86)\Git\bin\git.exe" (
    set "GIT_CMD=C:\Program Files (x86)\Git\bin\git.exe"
) else (
    where git >nul 2>&1
    if %errorlevel% equ 0 (
        set "GIT_CMD=git"
    ) else (
        echo Error: Git not found. Please install Git or add it to PATH.
        pause
        exit /b 1
    )
)

echo Using Git: %GIT_CMD%

echo Initializing Git repository...
"%GIT_CMD%" init

echo Configuring Git user...
"%GIT_CMD%" config user.name "abinav000"
"%GIT_CMD%" config user.email "abinavsanjay45@gmail.com"

echo Adding all files...
"%GIT_CMD%" add .

echo Creating initial commit...
"%GIT_CMD%" commit -m "Initial commit: Food Order System Spring Boot application"

echo Adding remote origin...
"%GIT_CMD%" remote add origin https://github.com/abinav000/Food-Order-System-.git

echo Setting main branch...
"%GIT_CMD%" branch -M main

echo Pushing to GitHub...
"%GIT_CMD%" push -u origin main

echo Done! Repository available at: https://github.com/abinav000/Food-Order-System-
pause