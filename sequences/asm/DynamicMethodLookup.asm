	.data
nl:
	.asciiz "\n"
_dml_tables:
	.word 0
	.text
	.globl main
main:
	subu	$sp, $sp, 32	# Push main stack frame
	sw	$ra, 20($sp)
	sw	$fp, 16($sp)
	addiu	$fp, $sp, 28
	li	$a0, 20		# Allocate dynamic method lookup tables
	li	$v0, 9
	syscall			# sbrk - Allocate memory
	sw	$v0, _dml_tables
	move	$v1, $v0
	li	$a0, 4		# Allocate dynamic method lookup table for class Test
	li	$v0, 9
	syscall			# sbrk - Allocate memory
	sw	$v0, 0($v1)
	la	$t0, Test.testMethods
	sw	$t0, 0($v0)
	li	$a0, 4		# Allocate dynamic method lookup table for class A
	li	$v0, 9
	syscall			# sbrk - Allocate memory
	sw	$v0, 4($v1)
	la	$t0, A.f
	sw	$t0, 0($v0)
	li	$a0, 8		# Allocate dynamic method lookup table for class B
	li	$v0, 9
	syscall			# sbrk - Allocate memory
	sw	$v0, 8($v1)
	la	$t0, A.f
	sw	$t0, 0($v0)
	la	$t0, B.g
	sw	$t0, 4($v0)
	li	$a0, 8		# Allocate dynamic method lookup table for class C
	li	$v0, 9
	syscall			# sbrk - Allocate memory
	sw	$v0, 12($v1)
	la	$t0, A.f
	sw	$t0, 0($v0)
	la	$t0, C.g
	sw	$t0, 4($v0)
	li	$a0, 8		# Allocate dynamic method lookup table for class D
	li	$v0, 9
	syscall			# sbrk - Allocate memory
	sw	$v0, 16($v1)
	la	$t0, D.f
	sw	$t0, 0($v0)
	la	$t0, C.g
	sw	$t0, 4($v0)
	li	$a0, 1		# NewObject Test size in words
	mul	$a0, $a0, 4
	li	$v0, 9
	syscall			# sbrk - Allocate memory
	add	$a0, $a0, $v0	# Clear allocated memory
allocClear0:
	sub	$a0, $a0, 4
	sw	$zero, 0($a0)
	bgt	$a0, $v0, allocClear0
	la	$v1, _dml_tables
	lw	$v1, 0($v1)	# address of table of tables
	lw	$v1, 0($v1)
	sw	$v1, 0($v0)	# Store identifier
	sub	$sp, $sp, 16	# Grow stack to hold all arguments
	sw	$v0, 0($sp)	# Call - this --> 0($sp)
	lw	$a0, 0($sp)
	add	$sp, $sp, 16
	lw	$v0, 0($a0)	# Load address of dynamic method lookup table
	lw	$v0, 0($v0)
	jalr	$ra, $v0
	move	$a0, $v0	# Print integer
	li	$v0, 1
	syscall
	la	$a0, nl		# Print newline
	li	$v0, 4
	syscall
	lw	$ra, 20($sp)	# Pop main stack frame
	lw	$fp, 16($sp)
	addiu	$sp, $sp, 32
	jr	$ra
	li	$v0, 10
	syscall			# Exit
Test.testMethods:
	sub	$sp, $sp, 48	# Push Test.testMethods stack frame
	sw	$fp, 24($sp)
	sw	$ra, 28($sp)
	sw	$a0, 32($sp)
	add	$fp, $sp, 44
	li	$a0, 1		# NewObject A size in words
	mul	$a0, $a0, 4
	li	$v0, 9
	syscall			# sbrk - Allocate memory
	add	$a0, $a0, $v0	# Clear allocated memory
allocClear1:
	sub	$a0, $a0, 4
	sw	$zero, 0($a0)
	bgt	$a0, $v0, allocClear1
	la	$v1, _dml_tables
	lw	$v1, 0($v1)	# address of table of tables
	lw	$v1, 4($v1)
	sw	$v1, 0($v0)	# Store identifier
	move	$v1, $v0
	add	$v0, $fp, -44	# Local Identifier a
	sw	$v1, 0($v0)	# Assign
	li	$a0, 1		# NewObject B size in words
	mul	$a0, $a0, 4
	li	$v0, 9
	syscall			# sbrk - Allocate memory
	add	$a0, $a0, $v0	# Clear allocated memory
allocClear2:
	sub	$a0, $a0, 4
	sw	$zero, 0($a0)
	bgt	$a0, $v0, allocClear2
	la	$v1, _dml_tables
	lw	$v1, 0($v1)	# address of table of tables
	lw	$v1, 8($v1)
	sw	$v1, 0($v0)	# Store identifier
	move	$v1, $v0
	add	$v0, $fp, -40	# Local Identifier b
	sw	$v1, 0($v0)	# Assign
	li	$a0, 1		# NewObject C size in words
	mul	$a0, $a0, 4
	li	$v0, 9
	syscall			# sbrk - Allocate memory
	add	$a0, $a0, $v0	# Clear allocated memory
allocClear3:
	sub	$a0, $a0, 4
	sw	$zero, 0($a0)
	bgt	$a0, $v0, allocClear3
	la	$v1, _dml_tables
	lw	$v1, 0($v1)	# address of table of tables
	lw	$v1, 12($v1)
	sw	$v1, 0($v0)	# Store identifier
	move	$v1, $v0
	add	$v0, $fp, -36	# Local Identifier c
	sw	$v1, 0($v0)	# Assign
	li	$a0, 1		# NewObject D size in words
	mul	$a0, $a0, 4
	li	$v0, 9
	syscall			# sbrk - Allocate memory
	add	$a0, $a0, $v0	# Clear allocated memory
allocClear4:
	sub	$a0, $a0, 4
	sw	$zero, 0($a0)
	bgt	$a0, $v0, allocClear4
	la	$v1, _dml_tables
	lw	$v1, 0($v1)	# address of table of tables
	lw	$v1, 16($v1)
	sw	$v1, 0($v0)	# Store identifier
	move	$v1, $v0
	add	$v0, $fp, -32	# Local Identifier d
	sw	$v1, 0($v0)	# Assign
	lw	$v0, -44($fp)	# Local IdentifierExp a
	sub	$sp, $sp, 16	# Grow stack to hold all arguments
	sw	$v0, 0($sp)	# Call - this --> 0($sp)
	lw	$a0, 0($sp)
	add	$sp, $sp, 16
	lw	$v0, 0($a0)	# Load address of dynamic method lookup table
	lw	$v0, 0($v0)
	jalr	$ra, $v0
	move	$a0, $v0	# Print integer
	li	$v0, 1
	syscall
	la	$a0, nl		# Print newline
	li	$v0, 4
	syscall
	lw	$v0, -40($fp)	# Local IdentifierExp b
	sub	$sp, $sp, 16	# Grow stack to hold all arguments
	sw	$v0, 0($sp)	# Call - this --> 0($sp)
	lw	$a0, 0($sp)
	add	$sp, $sp, 16
	lw	$v0, 0($a0)	# Load address of dynamic method lookup table
	lw	$v0, 0($v0)
	jalr	$ra, $v0
	move	$a0, $v0	# Print integer
	li	$v0, 1
	syscall
	la	$a0, nl		# Print newline
	li	$v0, 4
	syscall
	lw	$v0, -40($fp)	# Local IdentifierExp b
	sub	$sp, $sp, 16	# Grow stack to hold all arguments
	sw	$v0, 0($sp)	# Call - this --> 0($sp)
	lw	$a0, 0($sp)
	add	$sp, $sp, 16
	lw	$v0, 0($a0)	# Load address of dynamic method lookup table
	lw	$v0, 4($v0)
	jalr	$ra, $v0
	move	$a0, $v0	# Print integer
	li	$v0, 1
	syscall
	la	$a0, nl		# Print newline
	li	$v0, 4
	syscall
	lw	$v0, -36($fp)	# Local IdentifierExp c
	sub	$sp, $sp, 16	# Grow stack to hold all arguments
	sw	$v0, 0($sp)	# Call - this --> 0($sp)
	lw	$a0, 0($sp)
	add	$sp, $sp, 16
	lw	$v0, 0($a0)	# Load address of dynamic method lookup table
	lw	$v0, 0($v0)
	jalr	$ra, $v0
	move	$a0, $v0	# Print integer
	li	$v0, 1
	syscall
	la	$a0, nl		# Print newline
	li	$v0, 4
	syscall
	lw	$v0, -36($fp)	# Local IdentifierExp c
	sub	$sp, $sp, 16	# Grow stack to hold all arguments
	sw	$v0, 0($sp)	# Call - this --> 0($sp)
	lw	$a0, 0($sp)
	add	$sp, $sp, 16
	lw	$v0, 0($a0)	# Load address of dynamic method lookup table
	lw	$v0, 4($v0)
	jalr	$ra, $v0
	move	$a0, $v0	# Print integer
	li	$v0, 1
	syscall
	la	$a0, nl		# Print newline
	li	$v0, 4
	syscall
	lw	$v0, -32($fp)	# Local IdentifierExp d
	sub	$sp, $sp, 16	# Grow stack to hold all arguments
	sw	$v0, 0($sp)	# Call - this --> 0($sp)
	lw	$a0, 0($sp)
	add	$sp, $sp, 16
	lw	$v0, 0($a0)	# Load address of dynamic method lookup table
	lw	$v0, 0($v0)
	jalr	$ra, $v0
	move	$a0, $v0	# Print integer
	li	$v0, 1
	syscall
	la	$a0, nl		# Print newline
	li	$v0, 4
	syscall
	lw	$v0, -32($fp)	# Local IdentifierExp d
	sub	$sp, $sp, 16	# Grow stack to hold all arguments
	sw	$v0, 0($sp)	# Call - this --> 0($sp)
	lw	$a0, 0($sp)
	add	$sp, $sp, 16
	lw	$v0, 0($a0)	# Load address of dynamic method lookup table
	lw	$v0, 4($v0)
	jalr	$ra, $v0
	move	$a0, $v0	# Print integer
	li	$v0, 1
	syscall
	la	$a0, nl		# Print newline
	li	$v0, 4
	syscall
	lw	$v0, -36($fp)	# Local IdentifierExp c
	move	$v1, $v0
	add	$v0, $fp, -28	# Local Identifier b2
	sw	$v1, 0($v0)	# Assign
	lw	$v0, -32($fp)	# Local IdentifierExp d
	move	$v1, $v0
	add	$v0, $fp, -24	# Local Identifier b3
	sw	$v1, 0($v0)	# Assign
	lw	$v0, -28($fp)	# Local IdentifierExp b2
	sub	$sp, $sp, 16	# Grow stack to hold all arguments
	sw	$v0, 0($sp)	# Call - this --> 0($sp)
	lw	$a0, 0($sp)
	add	$sp, $sp, 16
	lw	$v0, 0($a0)	# Load address of dynamic method lookup table
	lw	$v0, 0($v0)
	jalr	$ra, $v0
	move	$a0, $v0	# Print integer
	li	$v0, 1
	syscall
	la	$a0, nl		# Print newline
	li	$v0, 4
	syscall
	lw	$v0, -28($fp)	# Local IdentifierExp b2
	sub	$sp, $sp, 16	# Grow stack to hold all arguments
	sw	$v0, 0($sp)	# Call - this --> 0($sp)
	lw	$a0, 0($sp)
	add	$sp, $sp, 16
	lw	$v0, 0($a0)	# Load address of dynamic method lookup table
	lw	$v0, 4($v0)
	jalr	$ra, $v0
	move	$a0, $v0	# Print integer
	li	$v0, 1
	syscall
	la	$a0, nl		# Print newline
	li	$v0, 4
	syscall
	lw	$v0, -24($fp)	# Local IdentifierExp b3
	sub	$sp, $sp, 16	# Grow stack to hold all arguments
	sw	$v0, 0($sp)	# Call - this --> 0($sp)
	lw	$a0, 0($sp)
	add	$sp, $sp, 16
	lw	$v0, 0($a0)	# Load address of dynamic method lookup table
	lw	$v0, 0($v0)
	jalr	$ra, $v0
	move	$a0, $v0	# Print integer
	li	$v0, 1
	syscall
	la	$a0, nl		# Print newline
	li	$v0, 4
	syscall
	lw	$v0, -24($fp)	# Local IdentifierExp b3
	sub	$sp, $sp, 16	# Grow stack to hold all arguments
	sw	$v0, 0($sp)	# Call - this --> 0($sp)
	lw	$a0, 0($sp)
	add	$sp, $sp, 16
	lw	$v0, 0($a0)	# Load address of dynamic method lookup table
	lw	$v0, 4($v0)
	jalr	$ra, $v0
	move	$a0, $v0	# Print integer
	li	$v0, 1
	syscall
	la	$a0, nl		# Print newline
	li	$v0, 4
	syscall
	li	$v0, 0		# IntegerLiteral 0
	lw	$fp, 24($sp)
	lw	$ra, 28($sp)
	add	$sp, $sp, 48	# Pop Test.testMethods stack frame
	jr	$ra		# Return from Test.testMethods
A.f:
	sub	$sp, $sp, 24	# Push A.f stack frame
	sw	$fp, 0($sp)
	sw	$ra, 4($sp)
	sw	$a0, 8($sp)
	add	$fp, $sp, 20
	li	$v0, 1		# IntegerLiteral 1
	lw	$fp, 0($sp)
	lw	$ra, 4($sp)
	add	$sp, $sp, 24	# Pop A.f stack frame
	jr	$ra		# Return from A.f
B.g:
	sub	$sp, $sp, 24	# Push B.g stack frame
	sw	$fp, 0($sp)
	sw	$ra, 4($sp)
	sw	$a0, 8($sp)
	add	$fp, $sp, 20
	li	$v0, 2		# IntegerLiteral 2
	lw	$fp, 0($sp)
	lw	$ra, 4($sp)
	add	$sp, $sp, 24	# Pop B.g stack frame
	jr	$ra		# Return from B.g
C.g:
	sub	$sp, $sp, 24	# Push C.g stack frame
	sw	$fp, 0($sp)
	sw	$ra, 4($sp)
	sw	$a0, 8($sp)
	add	$fp, $sp, 20
	li	$v0, 3		# IntegerLiteral 3
	lw	$fp, 0($sp)
	lw	$ra, 4($sp)
	add	$sp, $sp, 24	# Pop C.g stack frame
	jr	$ra		# Return from C.g
D.f:
	sub	$sp, $sp, 24	# Push D.f stack frame
	sw	$fp, 0($sp)
	sw	$ra, 4($sp)
	sw	$a0, 8($sp)
	add	$fp, $sp, 20
	li	$v0, 4		# IntegerLiteral 4
	lw	$fp, 0($sp)
	lw	$ra, 4($sp)
	add	$sp, $sp, 24	# Pop D.f stack frame
	jr	$ra		# Return from D.f
