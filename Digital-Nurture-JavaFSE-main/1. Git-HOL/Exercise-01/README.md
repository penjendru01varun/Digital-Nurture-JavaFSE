# Exercise 1: Git Setup, Configuration & Adding Files

## Objective
Set up machine with Git configuration, integrate Notepad++ as default editor, and add a file to the source code repository.

## Steps Performed

### Step 1: Git Configuration
```bash
git --version
git config --global user.name "ARON08-AJ"
git config --global user.email "aronjonath0807@gmail.com"
git config --global --list
```

### Step 2: Integrate Notepad++ as Default Editor
```bash
# Add notepad++ path to system environment variables
notepad++
git config --global core.editor "notepad++.exe -multiInst -notabbar -nosession -noPlugin"
git config --global -e
```

### Step 3: Add File to Repository
```bash
git init GitDemo
cd GitDemo
echo "Welcome to Git" > welcome.txt
cat welcome.txt
git status
git add welcome.txt
git commit -m "Added welcome.txt to repository"
git status
git remote add origin https://github.com/ARON08-AJ/GitDemo.git
git pull origin master
git push origin master
```

## Files Included
- `commands.txt`: All Git commands executed in this exercise.

## Output
Git is configured with user identity, Notepad++ is set as the default editor, and a file was added to the local and remote repository.
